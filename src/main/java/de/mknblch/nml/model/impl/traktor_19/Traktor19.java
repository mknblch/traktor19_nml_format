package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.common.XMLSerializer;
import de.mknblch.nml.entities.traktor_19.NML;
import de.mknblch.nml.model.Context;
import de.mknblch.nml.model.Library;
import de.mknblch.nml.model.ModelException;

import javax.xml.bind.JAXBException;
import java.nio.file.Path;

/**
 * Created by mknblch on 02.10.2015.
 *
 * Implementation of Traktor's collection.nml version 19.
 */
public class Traktor19 implements Context {

    private final XMLSerializer<NML> serializer = new XMLSerializer<>(NML.class, true);

    private final Path collectionPath;
    private final NML nml;
    private TraktorLibrary library;

    public Traktor19(Path collectionPath, NML nml) throws Exception {
        this.collectionPath = collectionPath;
        this.nml = nml;
        library = new TraktorLibrary(this, nml);
    }

    public Traktor19(Path collectionPath) throws Exception {
        this.collectionPath = collectionPath;
        try {
            nml = serializer.unmarshal(collectionPath.toFile());
        } catch (JAXBException e) {
            throw new ModelException("Cannot load library", e);
        }
        library = new TraktorLibrary(this, nml);
    }

    @Override
    public Library getLibrary() {
        return library;
    }

    @Override
    public void saveLibrary() throws ModelException {
        saveLibrary(collectionPath);
    }

    @Override
    public void saveLibrary(Path path) throws ModelException {
        if (null == library) {
            throw new ModelException("Library was not initialized");
        }
        try {
            serializer.marshal(nml, path.toFile());
        } catch (JAXBException e) {
            throw new ModelException("Cannot save library", e);
        }
    }

    @Override
    public String getVersion() {
        return "19";
    }

    @Override
    public Path getLibraryPath() {
        return collectionPath;
    }

}
