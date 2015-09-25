package de.mknblch.nml.mediator;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.common.FileLocation;
import de.mknblch.nml.common.ObjectDump;
import de.mknblch.nml.entities.*;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

import static de.mknblch.nml.mediator.NMLHelper.*;

/**
 *
 * Created by mknblch on 05.09.2015.
 */
public class NMLMediator {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    public static final String ROOT = "$ROOT";

    private final NML nml;
    private final NMLSerializer<NML> serializer;
    private final Map<String, String> volumes = new HashMap<>();
    private final Path path;

    public NMLMediator(Path pathToNML) throws JAXBException {
        path = pathToNML;
        serializer = new NMLSerializer<>(NML.class);
        nml = serializer.unmarshal(pathToNML.toFile());
    }

    public void save() throws JAXBException {
        serializer.marshal(nml, path.toFile());
    }

    public void dump() {
        new ObjectDump()
                .setShowType(true)
                .scan(nml)
                .printDump();
    }

    public NML getNml() {
        return nml;
    }

    public List<ENTRY> getCollection() {
        return nml.getCOLLECTION().getENTRY();
    }

    public ENTRY getCollectionEntry(Path path) {
        final FileLocation fileLocation = FileHelper.extractLocation(path);
        return getEntryFromCollection(
                stringToTraktorKey(fileLocation.file),
                stringToTraktorKey(fileLocation.directory),
                fileLocation.volume);
    }

    public ENTRY addOrGetCollectionEntry(Path path) {
        ENTRY entry = getCollectionEntry(path);
        if (null != entry) {
            return entry;
        }
        entry = new ENTRY();
        final List<Object> contentList = entry.getCONTENT();
        final MODIFICATIONINFO modificationinfo = new MODIFICATIONINFO();
        modificationinfo.setAUTHORTYPE("importer");
        final INFO info = new INFO();
        info.setIMPORTDATE(DATE_FORMAT.format(new Date(System.currentTimeMillis())));
        contentList.add(createLocation(path));
        contentList.add(modificationinfo);
        contentList.add(info);
        final COLLECTION collection = nml.getCOLLECTION();
        collection.getENTRY().add(entry);
        normalizeCollection();
        return entry;
    }

    public void addToPlaylist(String playlist, ENTRY track) {
        final PLAYLIST pl = getPlaylist(playlist);
        if (null == pl) {
            throw new IllegalArgumentException("Playlist " + playlist + " is unknown");
        }
        final ENTRY e = new ENTRY();
        e.getCONTENT().add(0, toPrimaryKey((LOCATION) getPrimaryContent(track)));
        pl.getENTRY().add(e);
        normalizePlaylist(pl);
    }

    public String findVolumeId (String volume) {
        String id = volumes.get(volume);
        if (null != id) {
            return id;
        }
        final Optional<String> entryOptional = getCollection().parallelStream()
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
        id = entryOptional.get();
        volumes.put(volume, id);
        return id;
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


    private PRIMARYKEY toPrimaryKey(LOCATION location) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(toKey(location));
        return primarykey;
    }

    private ENTRY getEntryFromCollection(String file, String dir, String volume) {
        final Optional<ENTRY> entryOptional = nml.getCOLLECTION().getENTRY().parallelStream()
                .filter(e -> belongsTo(e, file, dir, volume))
                .findFirst();
        return entryOptional.isPresent() ? entryOptional.get() : null;
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

    private boolean belongsTo(ENTRY entry, String file, String dir, String volume) {
        if (null == entry) {
            throw new IllegalArgumentException("LOCATION was null");
        }
        final Object content = getPrimaryContent(entry);
        if (content instanceof LOCATION) {
            return belongsTo((LOCATION) content, file, dir, volume);
        } else if (content instanceof PRIMARYKEY) {
            return belongsTo((PRIMARYKEY) content, file, dir, volume);
        }
        return false;
    }

    private boolean belongsTo(PRIMARYKEY content, String file, String dir, String volume) {
        final String key = locationToString(volume, dir, file);
        return key.equals(content.getKEY());
    }

    private boolean belongsTo(LOCATION location, String file, String dir, String volume) {
        if (null == file) {
            throw new IllegalArgumentException("FILE was null");
        }
        if (null != dir && !dir.equals(location.getDIR())) {
            return false;
        }
        if (null != volume && !volume.equals(location.getVOLUME())) {
            return false;
        }
        return file.equals(location.getFILE());
    }

    private NODE getPlaylistNode(String name) {
        final NODE rootNode = getPlaylistRootNode();
        if (ROOT.equals(name)) {
            return rootNode;
        }
        final Optional<NODE> nodeOptional = getPlaylistNodes()
                .parallelStream()
                .filter(n -> name.equals(n.getNAME()))
                .findFirst();

        if (!nodeOptional.isPresent()) {
            return null;
        }
        return nodeOptional.get();
    }

    public List<NODE> getPlaylistNodes() {
        return getPlaylistRootNode()
                .getSUBNODES()
                .getNODE();
    }

    private NODE getPlaylistRootNode() {
        final NODE root = nml.getPLAYLISTS().getNODE();
        verifyPlaylistRoot(root);
        return root;
    }

    private void verifyPlaylistRoot(NODE root) {
        if (!ROOT.equals(root.getNAME())) {
            throw new IllegalArgumentException("Invalid playlist");
        }
        if (!"FOLDER".equals(root.getTYPE())) {
            throw new IllegalArgumentException("Invalid root node type");
        }
        if (null == root.getSUBNODES()) {
            throw new IllegalArgumentException("Invalid root node - no subnodes");
        }
    }

    public PLAYLIST getPlaylist(String name) {
        final NODE node = getPlaylistNode(name);
        return node == null ? null : node.getPLAYLIST();
    }

    public PLAYLIST getOrCreatePlaylist(String name) {
        final PLAYLIST orig = getPlaylist(name);
        if (null != orig) {
            return orig;
        }
        final NODE root = getPlaylistRootNode();

        final PLAYLIST playlist = new PLAYLIST();
        playlist.setTYPE("LIST");
        playlist.setUUID(generateUUID());

        final NODE node = new NODE();
        node.setNAME(name);
        node.setTYPE("PLAYLIST");
        node.setPLAYLIST(playlist);

        final SUBNODES subnodes = root.getSUBNODES();
        subnodes.getNODE().add(node);
        normalizeSubnodes(subnodes);
        return playlist;
    }

    public void removeFromPlaylist(String playlistName, String primaryKey) {
        final PLAYLIST playlist = getPlaylist(playlistName);
        if (null == playlist) {
            throw new IllegalArgumentException("Unknown playlist: " + playlistName);
        }
        playlist.getENTRY().removeIf(e -> primaryKey.equals(getPrimaryContent(e, PRIMARYKEY.class).getKEY()));
        normalizePlaylist(playlist);
    }

    public void removePlaylists() {
        final SUBNODES subnodes = getPlaylistRootNode().getSUBNODES();
        subnodes.getNODE().clear();
        normalizeSubnodes(subnodes);
    }

    public void clearCollection() {
        nml.getCOLLECTION().getENTRY().clear();
        normalizeCollection();
    }

    private void normalizeCollection() {
        nml.getCOLLECTION().setENTRIES(nml.getCOLLECTION().getENTRY().size());
    }
}
