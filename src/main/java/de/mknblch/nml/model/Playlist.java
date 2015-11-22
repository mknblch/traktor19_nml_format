package de.mknblch.nml.model;

import java.util.List;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Playlist {

    String getName();

    void setName(String name);

    List<Track> getTracks();

    void addTrack(Track track);

    void addTracks(List<Track> tracks);

    void removeTrack(Track track);

    void clear();

    Context getContext();
}
