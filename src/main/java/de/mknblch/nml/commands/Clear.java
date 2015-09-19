package de.mknblch.nml.commands;

import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Clear collection and playlists")
@Command(trigger = "clear")
public class Clear extends TraktorCollection implements Runnable {

    @Override
    public void run() {
        nml().removePlaylists();
        nml().clearCollection();
        try {
            nml().save();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
