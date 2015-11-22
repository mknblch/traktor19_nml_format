package de.mknblch.nml.model;

import java.nio.file.Path;

/**
 * Created by mknblch on 29.09.2015.
 */
public interface Context {

    Library getLibrary() throws ModelException;

    void saveLibrary() throws ModelException;

    void saveLibrary(Path path) throws ModelException;

    String getVersion();

    Path getLibraryPath();

    Path getHomePath();

}
