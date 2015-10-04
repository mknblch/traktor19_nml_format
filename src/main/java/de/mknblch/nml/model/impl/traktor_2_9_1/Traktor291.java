package de.mknblch.nml.model.impl.traktor_2_9_1;

import de.mknblch.nml.entities.traktor_2_9_1.NML;
import de.mknblch.nml.mediator.XMLSerializer;
import de.mknblch.nml.model.Context;
import de.mknblch.nml.model.LibraryException;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;

/**
 * Created by mknblch on 02.10.2015.
 */
public class Traktor291 implements Context {

    private final XMLSerializer<NML> serializer;
    private final Path collectionPath;
    private TraktorLibrary library;

    Traktor291(Path collectionPath) throws Exception {
        this.collectionPath = collectionPath;
        serializer = new XMLSerializer<>(NML.class, true);
    }

    @Override
    public TraktorLibrary getLibrary() throws LibraryException {
        if (null == library) {
            try {
                library = new TraktorLibrary(serializer.unmarshal(collectionPath.toFile()));
            } catch (JAXBException e) {
                throw new LibraryException("Could not load library", e);
            }
        }
        return library;
    }

    @Override
    public void saveLibrary() throws LibraryException {
        if (null == library) {
            throw new LibraryException("Library was not initialized");
        }
        try {
            serializer.marshal(library.nml, collectionPath.toFile());
        } catch (JAXBException e) {
            throw new LibraryException("Could not save library", e);
        }
    }

    @Override
    public String getName() {
        return "Traktor";
    }

    @Override
    public String getVersion() {
        return "2.9.1";
    }
}
