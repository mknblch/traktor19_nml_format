package de.mknblch.nml.commands;

import de.mknblch.nml.common.BackupTools;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import java.io.IOException;
import java.util.Date;

/**
 * Created by mknblch on 18.09.2015.
 */
@Description("List collection backups")
@Command(trigger = {"backup", "list"})
public class BackupList extends TraktorCollection implements Runnable {

    @Description("Verbose output")
    @Argument(trigger = "--verbose", alt = "-v", length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {
        try {
            list();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void list() throws IOException {
        new BackupTools()
                .backupFiles()
                .forEach(file -> {
                    System.out.printf("%2$s | %1$td/%1$tm/%1$tY ~%3$dkB%n",
                            new Date(file.lastModified()),
                            verbose ? file.getAbsolutePath() : file.getName(),
                            file.length() / 1000
                    );
                });
    }
    
}
