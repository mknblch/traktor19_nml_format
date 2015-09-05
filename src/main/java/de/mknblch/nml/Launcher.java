package de.mknblch.nml;

import de.mknblch.nml.commands.Dump;
import de.mknblch.nml.commands.ListPlaylists;
import de.mknblch.params.Params;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 01.09.2015.
 */
public class Launcher {


    
    public static void main(String[] args) throws JAXBException {

        new Params()
                .add(Dump.class)
                .add(ListPlaylists.class)
                .runOrDie(args);
    }
}
