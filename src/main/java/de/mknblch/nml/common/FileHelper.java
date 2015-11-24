package de.mknblch.nml.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 14.09.2015.
 */
public class FileHelper {

    public static Path normalizePath(Path in) {
        return in.toAbsolutePath().normalize();
    }

    public static String normalizePathToString(Path in) {
        return normalizePathString(in.toAbsolutePath().normalize().toString());
    }

    public static String normalizePathString(String in) {
        return in.replaceAll("\\\\", "/");
    }

    public static List<Path> fetchSongPaths(Path directory) throws IOException {
        return Files.walk(directory)
                .map(FileHelper::normalizePath)
                .filter(FileTypeFilter.INSTANCE::isSupported)
                .collect(Collectors.toList());
    }

    public static List<Path> fetchSubdirectories(Path baseDirectory) throws IOException {
        final Path normalized = normalizePath(baseDirectory);
        return Files.walk(normalized, 1)
                .filter(Files::isDirectory)
                .filter(f -> normalized.compareTo(f) != 0)
                .collect(Collectors.toList());
    }
}
