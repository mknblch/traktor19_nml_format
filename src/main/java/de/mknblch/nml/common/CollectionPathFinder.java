package de.mknblch.nml.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 14.09.2015.
 */
public class CollectionPathFinder {

    public static final CollectionPathFinder INSTANCE = new CollectionPathFinder();

    private static final String NATIVE_INSTRUMENTS = "Native Instruments";
    private static final String USER_HOME = "user.home";
    private static final String COLLECTION_NML = "collection.nml";
    private static final String DOCUMENTS = "Documents";
    private static final String TRAKTOR_RECOGNIZER = "traktor";
    private static final Pattern VERSION_PATTERN = Pattern.compile("(\\d+)\\.(\\d+)(?:\\.(\\d+).*)?");

    public Set<String> getTraktorVersions() throws IOException {
        return Files.walk(getNIPath(), 1)
                .filter(Files::isDirectory)
                .map(Path::getFileName)
                .map(Path::toString)
                .map(String::toLowerCase)
                .filter(s -> s.startsWith(TRAKTOR_RECOGNIZER))
                .map(p -> p.substring(8))
                .collect(Collectors.toSet());
    }

    public Path getTraktorPath() throws IOException {
        return Paths.get(
                getUserHome(),
                DOCUMENTS,
                NATIVE_INSTRUMENTS,
                "Traktor " + getHighestVersion(getTraktorVersions()))
                .toAbsolutePath();
    }

    public Path getCollectionPath() throws IOException {
        return Paths.get(
                getTraktorPath().toString(),
                COLLECTION_NML);
    }

    private static long rate(String version) {
        final Matcher matcher = VERSION_PATTERN.matcher(version);
        if (!matcher.matches()) {
            return 0;
        }
        long v = Long.parseLong(matcher.group(1)) * 100000;
        final String g2 = matcher.group(2);
        final String g3 = matcher.group(3);
        v += null != g2 ? Long.parseLong(g2) * 1000 : 0;
        v += null != g3 ? Long.parseLong(g3) : 0;
        return v;
    }

    private static String getHighestVersion(Set<String> versions) throws IOException {
        return versions.stream().reduce("", (a, b) -> rate(a) > rate(b) ? a : b);
    }

    private Path getNIPath() {
        return Paths.get(getUserHome(), "Documents", NATIVE_INSTRUMENTS);
    }

    private String getUserHome() {
        return FileHelper.normalizePathString(System.getProperty(USER_HOME));
    }
}
