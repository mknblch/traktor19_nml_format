package de.mknblch.nml.commands;

import de.mknblch.objectdump.ObjectDump;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Dump nml")
@Command(trigger = "debug")
public class Debug extends TraktorCollection implements Runnable {

    @Override
    public void run() {
        new ObjectDump()
                .setShowType(true)
                .scan(getNml())
                .printDump();

    }
}
