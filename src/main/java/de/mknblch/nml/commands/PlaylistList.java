package de.mknblch.nml.commands;

import de.mknblch.nml.common.NMLHelper;
import de.mknblch.nml.entities.PRIMARYKEY;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "playlist", sub = "list", description = "List all playlists")
public class PlaylistList extends WithCollection implements Runnable {

    private static final String INDENT = "   ";

    @Argument(trigger = {"-v", "--verbose"}, description = "Verbose output", length = 0, optional = true)
    private boolean verbose = false;

    @Override
    public void run() {
        System.out.println("Playlists: ");
        for (String playlist : nml().getPlaylists()) {
            if (verbose) {
                System.out.println(playlist);
                for (PRIMARYKEY key : nml().getPlaylistPrimaryKeys(playlist)) {
                    System.out.printf("%s%s%n", INDENT, NMLHelper.traktorKeyToString(key.getKEY()));
                }
            } else {
                System.out.println(playlist);
            }
        }
    }
}
