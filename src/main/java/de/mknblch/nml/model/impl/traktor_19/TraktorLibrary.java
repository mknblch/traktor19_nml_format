package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.model.*;
import de.mknblch.nml.entities.traktor_19.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static de.mknblch.nml.model.impl.traktor_19.NMLHelper19.getPrimaryContent;
import static de.mknblch.nml.model.impl.traktor_19.NMLHelper19.stringToTraktorKey;

/**
 * Created by mknblch on 02.10.2015.
 */
public class TraktorLibrary implements Library {

    public static final String AUTHORTYPE = "importer";

    private final Context context;

    private final NML nml;

    TraktorLibrary(Context context, NML nml) {
        this.context = context;
        this.nml = nml;
    }

    @Override
    public Track getTrackById(String traktorKey) {
        final Optional<ENTRY> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> traktorKey.equals(NMLHelper19.getTraktorKey(e)))
                .findFirst();

        return entryOptional.isPresent() ? new TraktorTrack(context, entryOptional.get()) : null;
    }

    @Override
    public Track getTrack(Path path) {
        return getTrackById(NMLHelper19.pathToTraktorKey(path));
    }

    @Override
    public List<Track> listTracks() {
        return nml.getCOLLECTION().getENTRY().stream()
                .map(e -> new TraktorTrack(context, e))
                .collect(Collectors.toList());
    }

    @Override
    public Track importTrack(Path path) throws IOException {
        final Track track = getTrack(path);
        if (null != track) {
            return track;
        }
        final ENTRY newEntry = createCollectionEntry(path);
        nml.getCOLLECTION().getENTRY().add(newEntry);
        nml.getCOLLECTION().setENTRIES(nml.getCOLLECTION().getENTRY().size());
        return new TraktorTrack(context, newEntry);
    }

    @Override
    public Playlist createPlaylist(String playlistName) {
        final Playlist playlist = getPlaylist(playlistName);
        if (null != playlist) {
            return playlist;
        }
        return createNewPlaylist(playlistName);
    }

    @Override
    public void removePlaylist(String playlistName) {
        final SUBNODES subnodes = nml.getPLAYLISTS().getNODE().getSUBNODES();
        subnodes.getNODE().removeIf(node -> playlistName.equals(node.getNAME()));
        subnodes.setCOUNT(subnodes.getNODE().size());
    }

    @Override
    public void clearPlaylists() {
        final SUBNODES subnodes = nml.getPLAYLISTS().getNODE().getSUBNODES();
        subnodes.getNODE().clear();
        subnodes.setCOUNT(0);
    }

    @Override
    public Playlist getPlaylist(String nameOrPath) {
        final Optional<NODE> node = nml.getPLAYLISTS().getNODE().getSUBNODES().getNODE().parallelStream()
                .filter(n -> nameOrPath.equals(n.getNAME()))
                .findFirst();
        return node.isPresent() ? new TraktorPlaylist(context, node.get()) : null;
    }

    @Override
    public List<Playlist> listPlaylists() {
        return nml.getPLAYLISTS().getNODE().getSUBNODES().getNODE().stream()
                .map(e -> new TraktorPlaylist(context, e))
                .collect(Collectors.toList());
    }

    @Override
    public Context getContext() {
        return context;
    }

    private ENTRY createCollectionEntry(Path path) {
        final ENTRY entry = new ENTRY();

        final INFO info = new INFO();
        info.setIMPORTDATE(NMLHelper19.DATE_FORMAT.format(new Date(System.currentTimeMillis())));

        final MODIFICATIONINFO modificationinfo = new MODIFICATIONINFO();
        modificationinfo.setAUTHORTYPE(AUTHORTYPE);

        final List<Object> contentList = entry.getCONTENT();
        contentList.add(createLocation(path));
        contentList.add(modificationinfo);
        contentList.add(info);

        return entry;
    }

    private LOCATION createLocation(Path path) {
        final LOCATION location = new LOCATION();
        final FileLocation fileLocation = NMLHelper19.extractLocation(path);
        location.setVOLUME(stringToTraktorKey(fileLocation.volume));
        location.setDIR(stringToTraktorKey(fileLocation.directory));
        location.setFILE(fileLocation.file);
        location.setVOLUMEID(findVolumeId(fileLocation.volume));
        return location;
    }

    private String findVolumeId (String volume) {

        final Optional<String> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> belongsToVolume(e, volume))
                .map(ENTRY::getCONTENT)
                .map(c -> c.get(0))
                .filter(c -> c instanceof LOCATION)
                .map(c -> ((LOCATION) c).getVOLUMEID())
                .filter(Objects::nonNull)
                .findFirst();

        if (!entryOptional.isPresent()) {
            return "";
        }
        return entryOptional.get();
    }

    private boolean belongsToVolume(ENTRY entry, String volume) {
        final Object content = getPrimaryContent(entry);
        if (content instanceof LOCATION) {
            return volume.equals(((LOCATION) content).getVOLUME());
        } else if (content instanceof PRIMARYKEY) {
            return ((PRIMARYKEY) content).getKEY().startsWith(volume);
        }
        return false;
    }

    private Playlist createNewPlaylist(String playlistName) {
        final NODE root = nml.getPLAYLISTS().getNODE();

        final PLAYLIST tPlaylist = new PLAYLIST();
        tPlaylist.setTYPE("LIST");
        tPlaylist.setUUID(NMLHelper19.generateUUID());

        final NODE node = new NODE();
        node.setNAME(playlistName);
        node.setTYPE("PLAYLIST");
        node.setPLAYLIST(tPlaylist);

        final SUBNODES subnodes = root.getSUBNODES();
        subnodes.getNODE().add(node);
        subnodes.setCOUNT(subnodes.getNODE().size());

        return new TraktorPlaylist(context, node);
    }
}
