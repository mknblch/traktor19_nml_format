package de.mknblch.nml.model;

import java.nio.file.Path;

/**
 * Created by mknblch on 04.10.2015.
 */
public interface LibraryFactory<T extends Context> {

    public Library<T> build();
}
