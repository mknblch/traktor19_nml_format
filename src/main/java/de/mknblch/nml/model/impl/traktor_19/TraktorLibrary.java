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
public class TraktorLibrary implements Library{

    public static final String AUTHORTYPE = "importer";

    final NML nml;

    TraktorLibrary(NML nml) {
        this.nml = nml;
    }

    @Override
    public Track importTrack(Path path) throws IOException {
        final TraktorTrack track = getTrack(path);
        if (null != track) {
            return track;
        }
        final ENTRY newEntry = createCollectionEntry(path);
        nml.getCOLLECTION().getENTRY().add(newEntry);
        nml.getCOLLECTION().setENTRIES(nml.getCOLLECTION().getENTRY().size());
        return new TraktorTrack(newEntry);
    }

    @Override
    public List<Track> listTracks() {
        return nml.getCOLLECTION().getENTRY().stream()
                .map(TraktorTrack::new)
                .collect(Collectors.toList());
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
        return node.isPresent() ? new TraktorPlaylist(node.get()) : null;
    }

    @Override
    public List<Playlist> listPlaylists() {
        return nml.getPLAYLISTS().getNODE().getSUBNODES().getNODE().stream()
                .map(TraktorPlaylist::new)
                .collect(Collectors.toList());
    }

    @Override
    public TraktorTrack getTrack(Path path) {
        final FileLocation fileLocation = NMLHelper19.extractLocation(path);
        final String fileKey = stringToTraktorKey(fileLocation.file);
        final String dirKey = stringToTraktorKey(fileLocation.directory);
        final Optional<ENTRY> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> belongsTo(e, fileKey, dirKey, fileLocation.volume))
                .findFirst();

        return entryOptional.isPresent() ? new TraktorTrack(entryOptional.get()) : null;
    }

    private boolean belongsTo(ENTRY e, String file, String dir, String volume) {
        final List<Object> content = e.getCONTENT();
        if (null == content) {
            return false;
        }
        final Object first = content.get(0);
        if (null == first) {
            return false;
        }
        if (null == file) {
            throw new IllegalArgumentException("FILE was null");
        }
        if (null != dir && !dir.equals(((LOCATION) first).getDIR())) {
            return false;
        }
        if (null != volume && !volume.equals(((LOCATION) first).getVOLUME())) {
            return false;
        }
        return file.equals(((LOCATION) first).getFILE());
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
                .filter(e -> belongsTo(e, volume))
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

    private boolean belongsTo(ENTRY entry, String volume) {
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

        return new TraktorPlaylist(node);
    }
}
