package de.mknblch.nml.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLocation {

    public final String volume;
    public final String directory;
    public final String file;

    public FileLocation(String volume, String directory, String file) {
        this.volume = volume;
        this.directory = directory;
        this.file = file;
    }

    @Override
    public String toString() {
        return volume
                .concat(directory)
                .concat(file);
    }

    public Path toPath() {
        return Paths.get(toString());
    }

    public String toPrimaryKey() {
        return toString().replaceAll("/", "/:");
    }

    public String getVolume() {
        return volume;
    }

    public String getDirectory() {
        return directory;
    }

    public String getFile() {
        return file;
    }
}