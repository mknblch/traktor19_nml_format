package de.mknblch.nml.model;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * Created by mknblch on 29.09.2015.
 */
public interface Context {

    Library<? extends Context> getLibrary() throws LibraryException;

    void saveLibrary() throws LibraryException;

    void saveLibrary(Path path) throws LibraryException;

    String getVersion();

    Path getLibraryPath();

    Path getHomePath();

}
