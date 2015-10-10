package de.mknblch.nml.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mknblch on 10.10.2015.
 */
public class VersionExtractor {

    public static class NoCollectionException extends Exception {
        public NoCollectionException(String message) {
            super(message);
        }

        public NoCollectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static final Pattern VERSION_PATTERN = Pattern.compile(".*NML\\s+VERSION\\s*=\\s*\"([^\"]+)\".*", Pattern.DOTALL | Pattern.MULTILINE);

    public static String getCollectionVersion(Path pathToCollection) throws NoCollectionException {

        final Optional<String> first;
        try {
            final List<String> lines = Files.readAllLines(pathToCollection);
            first = lines.stream()
                    .map(data -> {
                        final Matcher matcher = VERSION_PATTERN.matcher(data);
                        return matcher.matches() ? matcher.group(1) : null;
                    })
                    .filter(Objects::nonNull)
                    .findFirst();

            if (!first.isPresent()) {
                throw new NoCollectionException("Version-Token not found");
            }

            return first.get();

        } catch (IOException e) {
            throw new NoCollectionException(pathToCollection + " not readable", e);
        }
    }
}
