package de.mknblch.nml.common;

import java.nio.file.Path;
import java.util.Set;

/**
 * Created by mknblch on 13.09.2015.
 */
public class PlaylistDiffResult {

    public final Set<Path> notInFiles;
    public final Set<Path> notInPlaylist;

    public PlaylistDiffResult(Set<Path> notInFiles, Set<Path> notInPlaylist) {
        this.notInFiles = notInFiles;
        this.notInPlaylist = notInPlaylist;
    }
}
