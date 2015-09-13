package de.mknblch.nml.commands;

import de.mknblch.nml.common.NMLHelper;
import de.mknblch.nml.entities.ENTRY;
import de.mknblch.nml.entities.LOCATION;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "collection", sub = "list", description = "List tracks in collection")
public class CollectionList extends WithCollection implements Runnable {

    @Argument(trigger = {"-v", "--verbose"}, description = "Verbose output", length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {

        final List<ENTRY> collection = getEditor().getCollection();
        for (ENTRY entry : collection) {
            if (verbose) {
                System.out.printf("%s :: %s - %s%n",
                        NMLHelper.locationToPath((LOCATION) entry.getCONTENT().get(0)),
                        entry.getARTIST(),
                        entry.getTITLE());
            } else {
                System.out.println(NMLHelper.locationToPath((LOCATION) entry.getCONTENT().get(0)));
            }
        }

    }
}
