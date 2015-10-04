package de.mknblch.nml.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

/**
 * Created by mknblch on 28.09.2015.
 *
 * library interface. must be implemented for specific contexts
 */
public interface Library<T extends Context> {

    /**
     * import track at path and return a track view to it.
     * if the track is already contained in this set the known
     * value is returned
     * @param path to the Track
     * @return Track-View to Track at path
     * @throws IOException
     */
    Track<T> importTrack(Path path) throws IOException;

    /**
     * get a list of all tracks
     * @return
     */
    List<Track<T>> getTracks();

    Playlists<T> getPlaylists();

}
