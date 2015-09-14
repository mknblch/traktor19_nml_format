package de.mknblch.nml.commands;

import de.mknblch.params.annotations.Command;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "clear", description = "Clear collection and playlists")
public class Clear extends WithCollection implements Runnable {

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
