package de.mknblch.nml.commands;

import de.mknblch.nml.entities.traktor.v2_9_1.NODE;
import de.mknblch.nml.entities.traktor.v2_9_1.PRIMARYKEY;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import static de.mknblch.nml.mediator.NMLHelper.*;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("List all playlists")
@Command(trigger = {"playlist", "list"})
public class PlaylistList extends TraktorCollection implements Runnable {

    private static final String INDENT = "   ";

    @Description("Verbose output")
    @Argument(trigger = "--verbose", alt = "-v", length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {
        for (NODE playlist : nml().getPlaylistNodes()) {
            System.out.println(playlist.getNAME());
            if (verbose) {
                playlist.getPLAYLIST().getENTRY().stream().forEach(entry -> {
                    System.out.printf("%s%s%n", INDENT, traktorKeyToString(getPrimaryContent(entry, PRIMARYKEY.class).getKEY()));
                });
            }
        }
    }
}
