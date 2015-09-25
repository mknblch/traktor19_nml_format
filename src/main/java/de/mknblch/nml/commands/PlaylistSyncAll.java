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
@Description("Sync all subdirectories to playlists")
@Command(trigger = {"playlist", "syncall"})
public class PlaylistSyncAll extends TraktorCollection implements Runnable {

    @Description("Path to directory")
    @Argument(trigger = "--directory", alt = "-d")
    protected Path directory;

    @Override
    public void run() {
        new SyncTools(nml()).syncAll(directory);
        try {
            nml().save();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
