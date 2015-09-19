package de.mknblch.nml.commands;

import de.mknblch.nml.diff.SyncTools;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Sync directory to playlist")
@Command(trigger = {"playlist", "sync"})
public class PlaylistSync extends TraktorCollection implements Runnable {

    @Description("Path to directory")
    @Argument(trigger = "-d")
    protected Path directory;

    @Description("Optional playlist name")
    @Argument(trigger = "-p", optional = true)
    protected String playlistName = null;

    @Override
    public void run() {
        new SyncTools(nml()).sync(directory, playlistName);
        try {
            nml().save();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
