package de.mknblch.nml.diff;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.entities.traktor_2_9_1.PLAYLIST;
import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.mediator.NMLMediator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

/**
 * Created by mknblch on 14.09.2015.
 */
public class SyncTools {
    
    private final NMLMediator nml;
    
    public SyncTools(NMLMediator nml) {
        this.nml = nml;
    }

    public void syncAll(Path directory) {
        try {
            System.out.printf("[SYNCALL] %s%n", directory);
            FileHelper.fetchSubdirectories(directory)
                    .forEach(this::sync);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sync(Path directory) {
        sync(directory, null);
    }

    public void sync(Path directory, String playlistName) {
        try {
            validateDirectory(directory);
            final List<Path> songs = FileHelper.fetchSongPaths(directory);
            if (null == playlistName) {
                playlistName = extractPlaylistName(directory);
            }
            System.out.printf("[SYNC] %s -> %s%n", directory, playlistName);
            // find playlist in collection
            final PLAYLIST playlist = nml.getPlaylist(playlistName);
            int newFiles = 0, removedFiles = 0;
            if (null == playlist) {
                final PLAYLIST virginPlaylist = nml.getOrCreatePlaylist(playlistName);
                newFiles = importSongs(songs, virginPlaylist);
            } else {
                final PlaylistDiffResult diffResult = new PlaylistDiffBuilder(playlist).build(songs);
                // remove songs from playlist which cant be found in directory
                removedFiles = removeSongs(diffResult.notInFiles, playlistName);
                newFiles = importSongs(diffResult.notInPlaylist, playlist);
            }
            System.out.printf("[%d new | %d removed]%n",
                    newFiles, removedFiles);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private int importSongs(Collection<Path> songs, PLAYLIST playlist) {
        return (int) songs.stream()
                .peek(f -> System.out.printf("[+] %s%n", f.toString()))
                .map(nml::addOrGetCollectionEntry)
                .map(NMLHelper::collectionEntryToPlaylistEntry)
                .peek(playlist.getENTRY()::add)
                .count();
    }
    
    private int removeSongs(Collection<Path> songs, String playlistName) {
        return (int) songs.stream()
                .peek(f -> System.out.printf("[-] %s%n", f.toString()))
                .map(NMLHelper::pathToPrimaryKey)
                .peek(pk -> nml.removeFromPlaylist(playlistName, pk))
                .count();
    }
    
    private String extractPlaylistName(Path directory) {
        return directory.toAbsolutePath().getFileName().toString();
    }
    
    private void validateDirectory(Path directory) {
        if (null == directory) {
            throw new IllegalArgumentException("Invalid path: null");
        }
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException("Invalid path (not a directory): " + directory);
        }
        if (null == directory.getFileName()) {
            throw new IllegalArgumentException("Invalid path (not a sub directory): " + directory);
        }
    }
}
