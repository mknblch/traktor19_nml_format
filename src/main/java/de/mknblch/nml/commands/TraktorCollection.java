package de.mknblch.nml.commands;

import de.mknblch.nml.common.CollectionPathFinder;
import de.mknblch.nml.mediator.NMLMediator;
import de.mknblch.nml.entities.NML;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Description;
import de.mknblch.params.transformer.PathTransformer;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by mknblch on 13.09.2015.
 */
public class TraktorCollection {

    private NMLMediator nml = null;

    @Description("Optional path to collection.nml")
    @Argument(trigger = "--collection", alt = "-c", transformer = PathTransformer.class, optional = true)
    protected Path collection = null;

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
            if (null == collection) {
                collection = CollectionPathFinder.INSTANCE.getCollectionPath();
            }
            nml = new NMLMediator(collection);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
