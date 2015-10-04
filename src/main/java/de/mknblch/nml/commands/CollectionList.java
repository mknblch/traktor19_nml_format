package de.mknblch.nml.commands;

import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.entities.traktor_2_9_1.ENTRY;
import de.mknblch.nml.entities.traktor_2_9_1.LOCATION;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import java.util.List;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("List tracks in collection")
@Command(trigger = {"collection", "list"})
public class CollectionList extends TraktorCollection implements Runnable {

    @Description("Verbose output")
    @Argument(trigger = "--verbose", alt = "-v", length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {

        final List<ENTRY> collection = nml().getCollection();
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
        System.out.println(collection.size() + " Files");
    }
}
