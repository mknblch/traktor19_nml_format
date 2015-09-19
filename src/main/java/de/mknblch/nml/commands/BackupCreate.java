package de.mknblch.nml.commands;

import de.mknblch.nml.common.BackupTools;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;
import de.mknblch.params.transformer.PathTransformer;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by mknblch on 18.09.2015.
 */
@Description("Backup collection.nml")
@Command(trigger = {"backup", "create"})
public class BackupCreate extends TraktorCollection implements Runnable {

    @Description("Verbose output")
    @Argument(trigger = {"-v", "--verbose"}, length = 0, optional = true)
    private boolean verbose = false;

    @Description("Optional backup name")
    @Argument(trigger = "-n", optional = true)
    private String name = null;

    @Description("Optional target path")
    @Argument(trigger = "-t", transformer = PathTransformer.class, optional = true)
    private Path target = null;

    @Override
    public void run() {
        try {
            final Path result = backup();
            final Path name = verbose ? result.getFileName() : result.getFileName();
            System.out.println("Backup created at " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path backup() throws IOException {
        final BackupTools backupTools = new BackupTools();
        if (null == name) {
            return backupTools.createBackup(target);
        }
        return backupTools.createNamedBackup(name);
    }
}
