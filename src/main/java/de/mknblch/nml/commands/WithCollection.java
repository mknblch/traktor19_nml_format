package de.mknblch.nml.commands;

import de.mknblch.nml.common.NMLMediator;
import de.mknblch.nml.entities.NML;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.transformer.FileTransformer;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mknblch on 13.09.2015.
 */
public class WithCollection {

    private NMLMediator nml = null;

    @Argument(trigger = {"-c", "--collection"}, transformer = FileTransformer.class, optional = true, description = "Path to collection.nml")
    protected Path collection = Paths.get("C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml");

    public NML getNml() {
        return nml().getNml();
    }

    public NMLMediator nml() {
        if (null == nml) {
            init();
        }
        return nml;
    }

    private void init () {
        try {
            nml = new NMLMediator(collection);
        } catch (JAXBException e) {
            e.printStackTrace(); // TODO
            System.exit(1);
        }
    }
}
