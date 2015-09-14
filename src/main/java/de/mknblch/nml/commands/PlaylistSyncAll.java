package de.mknblch.nml.commands;

import de.mknblch.nml.common.*;
import de.mknblch.nml.entities.PLAYLIST;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "playlist", sub = "syncall", description = "Sync all subdirectories to playlists")
public class PlaylistSyncAll extends WithCollection implements Runnable {

    @Argument(trigger = "-d", description = "Path to directory")
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
