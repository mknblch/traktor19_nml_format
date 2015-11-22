package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.model.FileLocation;
import de.mknblch.nml.entities.traktor_19.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Created by mknblch on 13.09.2015.
 */
class NMLHelper19 {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    public static final char[] UUID_CHARS = "abcdef0123456789".toCharArray();

    public static String getTraktorKey(ENTRY entry) {
        if (null == entry) {
            throw new IllegalArgumentException("Entry was null");
        }

        final Optional<PRIMARYKEY> primarykeyOptional = findContent(entry, PRIMARYKEY.class);
        if (primarykeyOptional.isPresent()) {
            return primarykeyOptional.get().getKEY();
        }

        final Optional<LOCATION> locationOptional = findContent(entry, LOCATION.class);
        if (locationOptional.isPresent()) {
            final LOCATION location = locationOptional.get();
            return String.join("", location.getVOLUME(), location.getDIR(), location.getFILE());
        }

        throw new IllegalArgumentException("Entry has no Key");
    }

    public static Path locationToPath(LOCATION location) {
        return Paths.get(locationToString(location.getVOLUME(), location.getDIR(), location.getFILE()));
    }

    public static String pathToTraktorKey(Path path) {
        return extractLocation(path).toPrimaryKey();
    }

    public static Path primaryKeyToPath(String primaryKey) {
        primaryKey = primaryKey.replaceAll("/:", "/");
        return Paths.get(primaryKey);
    }

    public static Path primaryKeyToPath(PRIMARYKEY primaryKey) {
        return primaryKeyToPath(primaryKey.getKEY());
    }

    public static String locationToString(String... location) {
        return String.format("%s%s%s",
                traktorKeyToString(location[0]),
                traktorKeyToString(location[1]),
                location[2]);
    }

    public static String traktorKeyToString(String key) {
        if (null == key) {
            return "";
        }
        return key.replaceAll("/:", "/");
    }

    public static String stringToTraktorKey(String str) {
        return str.replaceAll("/", "/:");
    }

    public static String generateUUID() {
        final Random random = new Random(System.currentTimeMillis());
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            builder.append(UUID_CHARS[random.nextInt(UUID_CHARS.length)]);
        }
        return builder.toString();
    }

    public static <T> T getPrimaryContent(ENTRY e, Class<T> clazz) {
        final Object content = getPrimaryContent(e);
        if (clazz.isAssignableFrom(content.getClass())) {
            return (T) content;
        }
        throw new IllegalArgumentException("Invalid class cast");
    }

    public static Object getPrimaryContent(ENTRY e) {
        final List<Object> contentList = e.getCONTENT();
        if (contentList.size() == 0) {
            throw new IllegalArgumentException("Empty content");
        }
        return e.getCONTENT().get(0);
    }

    public static Path getPath(ENTRY entry) {
        final Object primaryContent = getPrimaryContent(entry);
        if (null == primaryContent) {
            return null;
        }
        if (primaryContent instanceof PRIMARYKEY) {
            return NMLHelper19.primaryKeyToPath((PRIMARYKEY) primaryContent);
        }
        if (primaryContent instanceof LOCATION) {
            return NMLHelper19.locationToPath((LOCATION) primaryContent);
        }
        return null;
    }

    public static FileLocation extractLocation(Path path) {
        String pathString = FileHelper.normalizePathToString(path);
//        pathString = pathString.replaceAll("\\\\", "/");
        final int firstSlash = pathString.indexOf("/", 1);
        final int lastSlash = pathString.lastIndexOf("/");
        if (firstSlash == -1 || lastSlash == -1) {
            throw new IllegalArgumentException("Invalid path " + path);
        }
        String directory = null;
        if (firstSlash != lastSlash) {
            directory = pathString.substring(firstSlash, lastSlash + 1);
        }
        return new FileLocation(
                pathString.substring(0, firstSlash),
                directory,
                pathString.substring(lastSlash + 1));
    }

    public static <T> Optional<T> findContent(ENTRY entry, Class<T> type) {
        return entry.getCONTENT().stream()
                .filter(o -> type.isAssignableFrom(o.getClass()))
                .map(type::cast)
                .findFirst();
    }


}
