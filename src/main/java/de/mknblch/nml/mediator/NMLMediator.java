package de.mknblch.nml.mediator;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.common.FileLocation;
import de.mknblch.nml.entities.*;
import de.mknblch.objectdump.ObjectDump;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathNotFoundException;
import org.apache.commons.jxpath.Pointer;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * Created by mknblch on 05.09.2015.
 */
public class NMLMediator {


    private final static String ROOT = "$ROOT";

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    private final NML nml;
    private final JXPathContext context;
    private final XMLSerializer<NML> serializer;
    private final Map<String, String> volumes = new HashMap<>();
    private final Path path;

    public NMLMediator(Path pathToNML) throws JAXBException {
        path = pathToNML;
        serializer = new XMLSerializer<>(NML.class);
        nml = serializer.unmarshal(pathToNML.toFile());
        context = JXPathContext.newContext(nml);
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
        return selectMany("/COLLECTION/ENTRY", ENTRY.class);
    }

    public ENTRY getCollectionEntry(Path path) {
        final FileLocation fileLocation = FileHelper.extractLocation(path);
        return getEntryFromCollection(
                NMLHelper.stringToTraktorKey(fileLocation.file),
                NMLHelper.stringToTraktorKey(fileLocation.directory),
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
        final COLLECTION collection = select("/COLLECTION", COLLECTION.class);
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
        e.getCONTENT().add(toPrimaryKey((LOCATION) track.getCONTENT().get(0)));
        pl.getENTRY().add(e);
        NMLHelper.normalizePlaylist(pl);
    }

    public String findVolumeId (String volume) {
        String id = volumes.get(volume);
        if (null != id) {
            return id;
        }
        context.getVariables().declareVariable("VOLUME", volume);
        id = select("/COLLECTION//ENTRY['LOCATION']/*[@VOLUME=$VOLUME]/@VOLUMEID", String.class, "");
        volumes.put(volume, id);
        return id;
    }

    private LOCATION createLocation(Path path) {
        final LOCATION location = new LOCATION();
        final FileLocation fileLocation = FileHelper.extractLocation(path);
        location.setVOLUME(NMLHelper.stringToTraktorKey(fileLocation.volume));
        location.setDIR(NMLHelper.stringToTraktorKey(fileLocation.directory));
        location.setFILE(fileLocation.file);
        location.setVOLUMEID(findVolumeId(fileLocation.volume));
        return location;
    }

    private PRIMARYKEY toPrimaryKey(LOCATION location) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(NMLHelper.toKey(location));
        return primarykey;
    }

    private ENTRY getEntryFromCollection(String file, String dir, String volume) {
        context.getVariables().declareVariable("FILE", file);
        context.getVariables().declareVariable("DIR", dir);
        context.getVariables().declareVariable("VOLUME", volume);
        return (ENTRY) context.selectSingleNode("/COLLECTION/ENTRY/CONTENT['LOCATION'][@FILE=$FILE and @DIR=$DIR and @VOLUME=$VOLUME]/..");
    }

    private NODE getPlaylistNode(String name) {
        context.getVariables().declareVariable("PLNAME", name);
        return (NODE) context.selectSingleNode("/PLAYLISTS//NODE[@NAME=$PLNAME]");
    }

    public PLAYLIST getPlaylist(String name) {
        final NODE node = getPlaylistNode(name);
        return node == null ? null : node.getPLAYLIST();
    }

    public List<String> getPlaylists() {
        return selectMany("/PLAYLISTS//NODE[@NAME!='$ROOT']/@NAME", String.class);
    }

    public PLAYLIST getOrCreatePlaylist(String name) {
        final PLAYLIST orig = getPlaylist(name);
        if (null != orig) {
            return orig;
        }
        final NODE root = getPlaylistNode(ROOT);

        final PLAYLIST playlist = new PLAYLIST();
        playlist.setTYPE("LIST");
        playlist.setUUID(NMLHelper.generateUUID());

        final NODE node = new NODE();
        node.setNAME(name);
        node.setTYPE("PLAYLIST");
        node.setPLAYLIST(playlist);

        final SUBNODES subnodes = root.getSUBNODES();
        subnodes.getNODE().add(node);
        NMLHelper.normalizeSubnodes(subnodes);
        return playlist;
    }

    public void removeFromPlaylist(String playlistName, String primaryKey) {
        context.getVariables().declareVariable("PLNAME", playlistName);
        context.getVariables().declareVariable("TRACK", primaryKey);
        context.removePath("/PLAYLISTS//NODE[@NAME=$PLNAME]//ENTRY/CONTENT['PRIMARYKEY'][@TYPE='TRACK' and @KEY=$TRACK]/..");
        normalize(playlistName);
    }

    public void clearPlaylist(String playlist) {
        final PLAYLIST pl = getPlaylist(playlist);
        if (null != pl) {
            pl.getENTRY().clear();
            NMLHelper.normalizePlaylist(pl);
        }
    }

    public void removePlaylist(String playlist) {
        context.removePath("/PLAYLISTS//NODE[@NAME=$PLNAME]//ENTRY/CONTENT['PRIMARYKEY'][@TYPE='TRACK' and @KEY=$TRACK]/..");
    }

    public void removePlaylists() {
        context.removeAll("/PLAYLISTS//NODE[@NAME!='$ROOT']");
        NMLHelper.normalizeSubnodes(getPlaylistNode("$ROOT").getSUBNODES());
    }

    public void clearCollection() {
        nml.getCOLLECTION().getENTRY().clear();
        normalizeCollection();
    }

    public void removeFromPlaylists(String primaryKey) {
        context.getVariables().declareVariable("TRACK", primaryKey);
        final List<PLAYLIST> playlists = selectMany("/PLAYLISTS//ENTRY/CONTENT['PRIMARYKEY'][@TYPE='TRACK' and @KEY=$TRACK]/../..", PLAYLIST.class);
        for (PLAYLIST playlist : playlists) {
            final Iterator<ENTRY> iterator = playlist.getENTRY().iterator();
            while (iterator.hasNext()) {
                final ENTRY entry = iterator.next();
                if (primaryKey.equals(((PRIMARYKEY) entry.getCONTENT().get(0)).getKEY())) {
                    iterator.remove();
                }
            }
            NMLHelper.normalizePlaylist(playlist);
        }
    }

    private void normalize(String playlist) {
        context.getVariables().declareVariable("PLNAME", playlist);
        NMLHelper.normalizePlaylist(select("/PLAYLISTS//NODE[@NAME=$PLNAME]/PLAYLIST", PLAYLIST.class));
    }

    private void normalizeCollection() {
        nml.getCOLLECTION().setENTRIES(nml.getCOLLECTION().getENTRY().size());
    }

    public List<PRIMARYKEY> getPlaylistPrimaryKeys(String name) {
        context.getVariables().declareVariable("PLNAME", name);
        return selectMany("/PLAYLISTS//NODE[@NAME=$PLNAME]//ENTRY/CONTENT['PRIMARYKEY']", PRIMARYKEY.class);
    }

    public <T> List<T> selectMany(String xpath, Class<T> clazz) {
        final ArrayList<T> list = new ArrayList<>();
        for (Iterator<Pointer> i = context.iteratePointers(xpath); i.hasNext(); ) {
            list.add((T) i.next().getNode());
        }
        return list;
    }

    public <T> T select(String xpath, Class<T> clazz) {
        return (T) context.selectSingleNode(xpath);
    }

    public <T> T select(String xpath, Class<T> clazz, T defaultReturn) {
        try {
            return (T) context.selectSingleNode(xpath);
        } catch (JXPathNotFoundException e) {
            return defaultReturn;
        }
    }
}
