package de.mknblch.nml.commands;

import de.mknblch.objectdump.ObjectDump;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "dump", description = "Dump nml")
public class Dump extends WithCollection implements Runnable {

    @Argument(trigger = {"-x", "--xpath"}, description = "XPath to subnode", optional = true)
    private String xpath = null;

    @Override
    public void run() {
        if (null == xpath) {
            new ObjectDump()
                    .setShowType(true)
                    .scan(getNml())
                    .printDump();
        } else {
            new ObjectDump()
                    .setShowType(true)
                    .scan(nml().selectMany(xpath, Object.class))
                    .printDump();
        }
    }
}
