package de.mknblch.nml.diff;

import de.mknblch.nml.entities.traktor.v2_9_1.PLAYLIST;
import de.mknblch.nml.mediator.NMLHelper;

import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 13.09.2015.
 */
public class PlaylistDiffBuilder {

    private final PLAYLIST playlist;

    public PlaylistDiffBuilder(PLAYLIST playlist) {
        this.playlist = playlist;
    }

    private boolean playlistContains(Path path) {
        final String key = NMLHelper.pathToPrimaryKey(path);
        return playlist.getENTRY().stream().anyMatch(e -> key.equals(NMLHelper.getPrimaryKey(e).getKEY()));
    }

    public PlaylistDiffResult build(List<Path> files) {

        final Set<Path> notInPlaylist = files.stream()
                .filter(p -> !playlistContains(p))
                .collect(Collectors.toSet());

        final Set<String> pathKeys = files.stream().map(NMLHelper::pathToPrimaryKey)
                .collect(Collectors.toSet());

        final Set<Path> notInFiles = playlist.getENTRY().stream()
                .map(e -> NMLHelper.getPrimaryKey(e).getKEY())
                .filter(k -> !pathKeys.contains(k))
                .map(NMLHelper::primaryKeyToPath)
                .collect(Collectors.toSet());

        return new PlaylistDiffResult(notInFiles, notInPlaylist);
    }
}
