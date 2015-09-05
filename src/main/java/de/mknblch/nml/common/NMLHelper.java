package de.mknblch.nml.common;

import de.mknblch.nml.entities.PRIMARYKEY;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mknblch on 05.09.2015.
 */
public class NMLHelper {

    public static Path getFilePath(String key) {
        return Paths.get(key.replaceAll("/:", "/"));
    }

    public static Path getFilePath(PRIMARYKEY primarykey) {
        return getFilePath(primarykey.getKEY());
    }
}
