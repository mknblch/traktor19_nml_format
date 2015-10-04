package de.mknblch.nml.model;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by mknblch on 29.09.2015.
 */
public interface Context {

    /**
     * @return mother program name e.g. Traktor / Scratch Live
     */
    String getName();

    /**
     * @return program version e.g. 2.9.1
     */
    String getVersion();

    Library<? extends Context> getLibrary() throws LibraryException;

    void saveLibrary() throws LibraryException;

}
