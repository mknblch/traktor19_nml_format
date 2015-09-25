package de.mknblch.nml.commands;

import de.mknblch.nml.common.BackupTools;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 18.09.2015.
 */
@Description("Revert collection backup")
@Command(trigger = {"backup", "revert"})
public class BackupRevert extends TraktorCollection implements Runnable {

    @Description("Optional backup name")
    @Argument(trigger = "--name", alt = "-n", optional = true)
    private String name = null;

    @Override
    public void run() {
        try {
            if (null != name) {
                revertNamed();
            } else {
                revert();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void revertNamed() throws IOException {
        final Path path = new BackupTools().revertNamed(name);
        System.out.println("Reverting to " + path.getFileName());
    }


    private void revert() throws IOException {
        final BackupTools backupTools = new BackupTools();
        final List<File> files = backupTools.backupFiles()
                .collect(Collectors.toList());

        for (int i = 0; i < files.size(); i++) {
            final File file = files.get(i);
            System.out.printf("[%1$02d] %3$s | %2$td/%2$tm/%2$tY ~%4$dkB%n",
                    i+1,
                    new Date(file.lastModified()),
                    file.getName(),
                    file.length() / 1000
            );
        }

        System.out.print("Select file or quit [q]: ");

        try {
            final int n = new Scanner(System.in).nextInt()-1;
            if (n >= files.size()) {
                throw new IllegalArgumentException("Invalid index");
            }
            final File file = files.get(n);
            System.out.println("Reverting to " + file);
            backupTools.revertTo(file.toPath());
        } catch (InputMismatchException ignored) {}
    }
    
}
