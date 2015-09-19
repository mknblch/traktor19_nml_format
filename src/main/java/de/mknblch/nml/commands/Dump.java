package de.mknblch.nml.commands;

import de.mknblch.objectdump.ObjectDump;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Dump nml")
@Command(trigger = "dump")
public class Dump extends TraktorCollection implements Runnable {

    @Description("XPath to subnode")
    @Argument(trigger = {"-x", "--xpath"}, optional = true)
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
