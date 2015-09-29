package de.mknblch.nml.mediator;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.entities.traktor.v2_9_1.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * Created by mknblch on 13.09.2015.
 */
public class NMLHelper {

    public static final char[] UUID_CHARS = "abcdef0123456789".toCharArray();

    public static String toKey(LOCATION location) {
        return String.join("", location.getVOLUME(), location.getDIR(), location.getFILE());
    }

    public static Path locationToPath(LOCATION location) {
        return Paths.get(locationToString(location.getVOLUME(), location.getDIR(), location.getFILE()));
    }

    public static String pathToPrimaryKey(Path path) {
        return FileHelper.extractLocation(path).toPrimaryKey();
    }

    public static Path primaryKeyToPath(String primaryKey) {
        // TODO WATCH
//        primaryKey = primaryKey.replaceAll("&amp;", "&");
        primaryKey = primaryKey.replaceAll("/:", "/");
        return Paths.get(primaryKey);
    }

    public static PRIMARYKEY locationToPrimaryKey(LOCATION location) {
        final PRIMARYKEY primarykey = new PRIMARYKEY();
        primarykey.setTYPE("TRACK");
        primarykey.setKEY(toKey(location));
        return primarykey;
    }

    public static String locationToString(String... location) {
        return String.format("%s%s%s",
                traktorKeyToString(location[0]),
                traktorKeyToString(location[1]),
                location[2]);
    }

    public static String traktorKeyToString(String key) {
        return key.replaceAll("/:", "/");
    }

    public static String stringToTraktorKey(String str) {
        return str.replaceAll("/", "/:");
    }

    public static void addToPlaylistIfUnknown(PLAYLIST playlist, ENTRY entry) {
        if (playlist.getENTRY().stream().anyMatch(e -> primaryKeyEquals(e, entry))) {
            return;
        }
        playlist.getENTRY().add(entry);
        normalizePlaylist(playlist);
    }

    public static void normalizeSubnodes(SUBNODES subnodes) {
        subnodes.setCOUNT(subnodes.getNODE().size());
    }

    public static void normalizePlaylist(PLAYLIST playlist) {
        playlist.setENTRIES(playlist.getENTRY().size());
    }

    public static boolean primaryKeyEquals(ENTRY a, ENTRY b) {
        return getPrimaryKey(a).getKEY().equals(getPrimaryKey(b).getKEY());
    }

    public static PRIMARYKEY getPrimaryKey(ENTRY entry) {
        final Object o = entry.getCONTENT().get(0);
        if (o instanceof PRIMARYKEY) {
            return (PRIMARYKEY) o;
        }
        throw new IllegalArgumentException("Invalid ENTRY Type");
    }


    public static String generateUUID() {
        final Random random = new Random(System.currentTimeMillis());
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            builder.append(UUID_CHARS[random.nextInt(UUID_CHARS.length)]);
        }
        return builder.toString();
    }

    public static ENTRY collectionEntryToPlaylistEntry(ENTRY entry) {

        final Object e = entry.getCONTENT().get(0);

        if (e instanceof PRIMARYKEY) {
            throw new IllegalArgumentException("Invalid ENTRY Type - Origin must be COLLECTION");
        }

        final ENTRY plEntry = new ENTRY();
        plEntry.getCONTENT().add(locationToPrimaryKey((LOCATION) e));
        return plEntry;
    }

    public static <T> T getPrimaryContent(ENTRY e, Class<T> clazz) {
        final Object content = getPrimaryContent(e);
        if (clazz.isAssignableFrom(content.getClass())) {
            return (T) content;
        }
//        if (content.getClass().isAssignableFrom(clazz)) {
//        return (T) content;
//        }
        throw new IllegalArgumentException("Invalid class cast");
    }

    public static Object getPrimaryContent(ENTRY e) {
        final List<Object> contentList = e.getCONTENT();
        if (contentList.size() == 0) {
            throw new IllegalArgumentException("Empty content");
        }
        return e.getCONTENT().get(0);
    }
}
