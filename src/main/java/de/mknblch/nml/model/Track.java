package de.mknblch.nml.model;

import java.nio.file.Path;
import java.util.Map;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Track<T extends Context> {

    Path getPath();

    Path getFile();

    Map<String, Object> getProperties();
}
