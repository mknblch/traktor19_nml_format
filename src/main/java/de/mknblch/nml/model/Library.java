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

    public Track<T> getTrack(Path path);

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
    List<Track<T>> listTracks();

    /**
     * create a new playlist with specified name
     * or return return an existing one
     * @param playlistName
     * @return
     */
    Playlist<T> createPlaylist(String playlistName);

    /**
     * remove playlist if exists
     * @param playlistName
     */
    void removePlaylist(String playlistName);

    void clearPlaylists();

    Playlist<T> getPlaylist(String name);

    List<Playlist<T>> listPlaylists();

}
