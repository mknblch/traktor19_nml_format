package de.mknblch.nml.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.StandardCopyOption.*;

/**
 * Created by mknblch on 18.09.2015.
 */
public class BackupTools {

    public static final String COLLECTION_BACKUP = "collection_backup";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddhhmmss");

    private final Path traktorPath;
    private Path collectionPath;

    public BackupTools() throws IOException {
        this.traktorPath = CollectionPathFinder.INSTANCE.getTraktorPath();
        this.collectionPath = CollectionPathFinder.INSTANCE.getCollectionPath();
    }

    public Path createBackup(Path target) throws IOException {
        if (null == target) {
            target = createBackupPath();
        }
        Files.copy(collectionPath, target);
        return target;
    }


    public Path createNamedBackup(String name) throws IOException {
        final Path target = Paths.get(
                traktorPath.toString(),
                buildCollectionName(name));

        Files.copy(collectionPath, target);
        return target;
    }

    public Stream<File> backupFiles() throws IOException {
        return Files.walk(traktorPath, 1)
                .filter(Files::isRegularFile)
                .map(Path::toAbsolutePath)
                .filter(this::isBackupFile)
                .map(Path::toFile)
                .sorted((a, b) -> {
                    final long am = a.lastModified();
                    final long bm = b.lastModified();
                    return am > bm ? -1 : 1;
                });
    }

    public void revertTo(Path backup) throws IOException {
        Files.copy(backup, collectionPath,
                REPLACE_EXISTING,
                COPY_ATTRIBUTES);
    }


    public Path revertNamed(String name) throws IOException {
        final List<File> collect = backupFiles()
                .filter(p -> p.toString().endsWith(COLLECTION_BACKUP + "_" + name + ".nml"))
                .collect(Collectors.toList());
        if (collect.size() == 0) {
            throw new IllegalArgumentException("Backup " + name + " not found");
        }
        final Path backup = collect.get(0).toPath();
        revertTo(backup);
        return backup;
    }

    private Path createBackupPath() {
        return Paths.get(
                traktorPath.toString(),
                buildCollectionName(DATE_FORMAT.format(System.currentTimeMillis()))
        );
    }

    private String buildCollectionName(String name) {
        return String.format("%s_%s.nml",
                COLLECTION_BACKUP,
                name);
    }

    private boolean isBackupFile(Path path) {
        if (!path.toString().toLowerCase().endsWith(".nml")) {
            return false;
        }
        return path.getFileName().toString().startsWith(COLLECTION_BACKUP);
    }

}
