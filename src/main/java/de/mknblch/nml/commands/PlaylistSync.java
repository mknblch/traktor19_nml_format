package de.mknblch.nml.commands;

import de.mknblch.params.annotations.Command;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "playlist", sub = "sync", description = "Sync directory with playlist")
public class PlaylistSync extends WithCollection implements Runnable {

    @Override
    public void run() {

    }
}
