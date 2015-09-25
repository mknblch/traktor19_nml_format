package de.mknblch.nml.commands;

import de.mknblch.nml.common.TypeHelper;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Import tracks to collection")
@Command(trigger = {"collection", "import"})
public class CollectionImport extends TraktorCollection implements Runnable {

    @Description("Path to directory")
    @Argument(trigger = "--directory", alt = "-d")
    private Path directory;

    @Override
    public void run() {
        try {
            Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .filter(TypeHelper.INSTANCE::isSupported)
                    .forEach(nml()::addOrGetCollectionEntry);

            nml().save();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
