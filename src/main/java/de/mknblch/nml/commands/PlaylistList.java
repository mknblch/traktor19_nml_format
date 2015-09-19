package de.mknblch.nml.commands;

import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.entities.PRIMARYKEY;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("List all playlists")
@Command(trigger = {"playlist", "list"})
public class PlaylistList extends TraktorCollection implements Runnable {

    private static final String INDENT = "   ";

    @Description("Verbose output")
    @Argument(trigger = {"-v", "--verbose"}, length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {
        for (String playlist : nml().getPlaylists()) {
            System.out.println("[" + playlist + "]");
            if (verbose) {
                for (PRIMARYKEY key : nml().getPlaylistPrimaryKeys(playlist)) {
                    System.out.printf("%s%s%n", INDENT, NMLHelper.traktorKeyToString(key.getKEY()));
                }
            }
        }
    }
}
