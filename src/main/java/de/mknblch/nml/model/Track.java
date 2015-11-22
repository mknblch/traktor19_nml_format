package de.mknblch.nml.model;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;

/**
 * Created by mknblch on 28.09.2015.
 */
public interface Track {

    Path getPath();

    String getFileName();

    String getTitle();

    String getArtist();

    Integer getBitrate();

    String getComment();

    Date getImportDate();

    Date getLastPlayed();

    String getKey();

    boolean isAnalyzed();

    String getAudioID();

}
