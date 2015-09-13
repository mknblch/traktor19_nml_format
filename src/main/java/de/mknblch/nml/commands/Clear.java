package de.mknblch.nml.commands;

import de.mknblch.nml.common.NMLHelper;
import de.mknblch.nml.entities.ENTRY;
import de.mknblch.nml.entities.LOCATION;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "clear", description = "Clear collection and playlists")
public class Clear extends WithCollection implements Runnable {

    @Override
    public void run() {
        getEditor().removePlaylists();
        getEditor().clearCollection();
        try {
            getEditor().save();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
