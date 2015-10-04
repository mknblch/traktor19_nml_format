package de.mknblch.nml.model;

import java.util.List;

/**
 * Created by mknblch on 02.10.2015.
 */
public interface Playlists<T extends Context> {

    /**
     * create a new playlist with specified name
     * or return return an existing one
     * @param playlistName
     * @return
     */
    Playlist<T> create(String playlistName);

    /**
     * remove playlist if exists
     * @param playlistName
     */
    void remove(String playlistName);

    void clear();

    Playlist<T> get(String name);

    List<Playlist<T>> list();

}
