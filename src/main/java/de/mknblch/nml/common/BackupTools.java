package de.mknblch.nml.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mknblch on 18.09.2015.
 */
public class BackupTools {

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final String COLLECTION_NAME_FORMAT = "%s_%s.nml";
    private static final String COLLECTION_BACKUP = "collection_backup";
    private static final String FILE_SUFFIX = ".nml";

    private static final Comparator<File> BY_MODIFIED_DATE = (a, b) -> {
        final long am = a.lastModified();
        final long bm = b.lastModified();
        return am > bm ? -1 : 1;
    };

    //

    private final Path traktorPath;
    private Path collectionPath;

    //

    public BackupTools() throws IOException {
        this.traktorPath = TraktorPathFinder.INSTANCE.getTraktorPath("2.9.1");
        this.collectionPath = TraktorPathFinder.INSTANCE.getCollectionPath("2.9.1");
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
                .sorted(BY_MODIFIED_DATE);
    }

    public void revertTo(Path backup) throws IOException {
        Files.copy(backup, collectionPath,
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES);
    }


    public Path revertNamed(String name) throws IOException {
        final List<File> collect = backupFiles()
                .filter(p -> p.toString().endsWith(COLLECTION_BACKUP + "_" + name + FILE_SUFFIX))
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
        return String.format(COLLECTION_NAME_FORMAT,
                COLLECTION_BACKUP,
                name);
    }

    private boolean isBackupFile(Path path) {
        return path.toString()
                .toLowerCase()
                .endsWith(FILE_SUFFIX) &&

                path.getFileName()
                .toString()
                .startsWith(COLLECTION_BACKUP);
    }

}
