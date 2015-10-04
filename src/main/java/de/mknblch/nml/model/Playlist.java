package de.mknblch.nml.model;

import java.util.List;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Playlist<T extends Context> {

    String getName();

    void setName(String name);

    List<Track<T>> getTracks();

    void addTrack(Track<T> track);

    void removeTrack(Track<T> track);

    void clear();

    void addAll(List<Track<T>> tracks);

}