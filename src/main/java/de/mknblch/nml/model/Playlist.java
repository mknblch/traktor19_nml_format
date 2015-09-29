package de.mknblch.nml.model;

import java.util.List;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Playlist {

    String getName();

    void setName(String name);

    List<Track> getTracks();

    List<Playlist> getPlaylists();

    void addTrack(Track track);

    void removeTrack(Track track);

    void clear();

    void addAll(List<Track> tracks);

    void addPlaylist(Playlist playlist);
}
