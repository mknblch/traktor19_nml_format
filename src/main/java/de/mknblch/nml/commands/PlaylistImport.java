package de.mknblch.nml.commands;

import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.common.TypeHelper;
import de.mknblch.nml.entities.traktor.v2_9_1.PLAYLIST;
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
@Description("Import unknown tracks into existing playlist or create new playlist by directory name")
@Command(trigger = {"playlist", "import"})
public class PlaylistImport extends TraktorCollection implements Runnable {

    @Description("Path to directory")
    @Argument(trigger = "--directory", alt = "-d")
    private Path directory;

    @Override
    public void run() {

        try {
            importDirectory();
        } catch (IOException | JAXBException e) {
            e.printStackTrace(); // TODO
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

    }

    private void importDirectory() throws IOException, JAXBException {
        final Path name = directory.toAbsolutePath().getFileName();

        if (null == name) {
            throw new IllegalArgumentException("Invalid Path");
        }

        System.out.printf("import %s -> %s%n", directory.toAbsolutePath().toString(), name.toString());
        final PLAYLIST playlist = nml().getOrCreatePlaylist(name.toString());
        Files.walk(directory)
                .filter(Files::isRegularFile)
                .filter(TypeHelper.INSTANCE::isSupported)
                .map(Path::toAbsolutePath)
                .peek(p -> System.out.printf("[+] %s%n", p.toString()))
                .map(nml()::addOrGetCollectionEntry)
                .map(NMLHelper::collectionEntryToPlaylistEntry)
                .forEach(e -> NMLHelper.addToPlaylistIfUnknown(playlist, e));
        nml().save();
    }
}
