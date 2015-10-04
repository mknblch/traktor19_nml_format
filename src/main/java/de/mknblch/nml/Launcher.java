package de.mknblch.nml;

import de.mknblch.nml.common.PropertyLoader;
import de.mknblch.params.Params;

import javax.xml.bind.JAXBException;

/**
 * Created by mknblch on 01.09.2015.
 */
public class Launcher {

    public static void main(String[] args) throws JAXBException {

        final PropertyLoader loader = PropertyLoader.init("properties");

        new Params()
                .setDescription(loader.get("version"))
                .runOrDie(args);
    }
}
