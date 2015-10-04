package de.mknblch.nml.model.impl.traktor_2_9_1;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.common.FileLocation;
import de.mknblch.nml.entities.traktor_2_9_1.*;
import de.mknblch.nml.model.Library;
import de.mknblch.nml.model.Playlists;
import de.mknblch.nml.model.Track;

import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static de.mknblch.nml.mediator.NMLHelper.getPrimaryContent;
import static de.mknblch.nml.mediator.NMLHelper.stringToTraktorKey;

/**
 * Created by mknblch on 02.10.2015.
 */
public class TraktorLibrary implements Library<Traktor291>{

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    public static final String AUTHORTYPE = "importer";

    final NML nml;

    TraktorLibrary(NML nml) {
        this.nml = nml;
    }

    @Override
    public Track<Traktor291> importTrack(Path path) throws IOException {
        final ENTRY entry = getCollectionEntry(path);
        if (null != entry) {
            return new TraktorTrack(entry);
        }
        final ENTRY newEntry = createCollectionEntry(path);
        nml.getCOLLECTION().getENTRY().add(newEntry);
        nml.getCOLLECTION().setENTRIES(nml.getCOLLECTION().getENTRY().size());
        return new TraktorTrack(newEntry);
    }

    @Override
    public List<Track<Traktor291>> getTracks() {
        return nml.getCOLLECTION().getENTRY().stream()
                .map(TraktorTrack::new)
                .collect(Collectors.toList());
    }

    @Override
    public Playlists<Traktor291> getPlaylists() {
        return new TraktorPlaylists(nml.getPLAYLISTS());
    }
    private ENTRY getCollectionEntry(Path path) {
        final FileLocation fileLocation = FileHelper.extractLocation(path);
        return getEntryFromCollection(
                stringToTraktorKey(fileLocation.file),
                stringToTraktorKey(fileLocation.directory),
                fileLocation.volume);
    }

    private ENTRY getEntryFromCollection(String file, String dir, String volume) {
        final Optional<ENTRY> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> belongsTo(e, file, dir, volume))
                .findFirst();
        return entryOptional.isPresent() ? entryOptional.get() : null;
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
        info.setIMPORTDATE(DATE_FORMAT.format(new Date(System.currentTimeMillis())));

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
        final FileLocation fileLocation = FileHelper.extractLocation(path);
        location.setVOLUME(stringToTraktorKey(fileLocation.volume));
        location.setDIR(stringToTraktorKey(fileLocation.directory));
        location.setFILE(fileLocation.file);
        location.setVOLUMEID(findVolumeId(fileLocation.volume));
        return location;
    }

    public String findVolumeId (String volume) {

        final Optional<String> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> belongsTo(e, volume))
                .map(ENTRY::getCONTENT)
                .map(c -> c.get(0))
                .filter(c -> c instanceof LOCATION)
                .map(c -> (LOCATION) c)
                .map(LOCATION::getVOLUMEID)
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

}
