package de.mknblch.nml.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Library extends Set<Track> {

    /**
     * @return mother program name e.g. Traktor / Scratch Live
     */
    String getName();

    /**
     * @return program version e.g. 2.10.0
     */
    String getVersion();

    /**
     * import track at path
     * @param path
     * @return
     */
    Track importTrack(Path path) throws LibraryException, FileNotFoundException, IOException;

    boolean containsTrackAt(Path path) throws FileNotFoundException;
}
