package de.mknblch.nml.diff;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.entities.PLAYLIST;
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
            
            if (null == playlist) {
                final PLAYLIST virginPlaylist = nml.getOrCreatePlaylist(playlistName);
                importSongs(songs, virginPlaylist);
            } else {
                final PlaylistDiffResult diffResult = new PlaylistDiffBuilder(playlist).build(songs);
                // remove songs from playlist which cant be found in directory
                removeSongs(diffResult.notInFiles, playlistName);
                importSongs(diffResult.notInPlaylist, playlist);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void importSongs(Collection<Path> songs, PLAYLIST playlist) {
        songs.stream()
                .peek(f -> System.out.printf("[+] %s%n", f.toString()))
                .map(nml::addOrGetCollectionEntry)
                .map(NMLHelper::collectionEntryToPlaylistEntry)
                .forEach(playlist.getENTRY()::add);
    }
    
    private void removeSongs(Collection<Path> songs, String playlistName) {
        songs.stream()
                .peek(f -> System.out.printf("[-] %s%n", f.toString()))
                .map(NMLHelper::pathToPrimaryKey)
                .forEach(pk -> nml.removeFromPlaylist(playlistName, pk));
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
