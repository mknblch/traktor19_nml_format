package de.mknblch.nml.commands;

import de.mknblch.nml.common.TypeHelper;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "collection", sub = "import", description = "Import tracks to collection")
public class CollectionImport extends WithCollection implements Runnable {

    @Argument(trigger = "-d", description = "Path to directory")
    private Path directory;

    @Override
    public void run() {
        try {
            Files.walk(directory)
                    .filter(Files::isRegularFile)
                    .filter(TypeHelper.INSTANCE::isSupported)
                    .forEach(getEditor()::addCollectionEntry);

            getEditor().save();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
