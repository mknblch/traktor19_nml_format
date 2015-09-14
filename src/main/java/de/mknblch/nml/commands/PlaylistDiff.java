package de.mknblch.nml.commands;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.common.PlaylistDiffBuilder;
import de.mknblch.nml.common.PlaylistDiffResult;
import de.mknblch.nml.common.TypeHelper;
import de.mknblch.nml.entities.PLAYLIST;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "playlist", sub = "diff", description = "Show difference between directory and playlist")
public class PlaylistDiff extends WithCollection implements Runnable {

    @Argument(trigger = "-d", description = "Path to directory")
    private Path directory;

    @Override
    public void run() {
        try {
            diff(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void diff(Path directory) throws IOException {
        final List<Path> files = Files.walk(directory)
                .map(FileHelper::normalizePath)
                .filter(TypeHelper.INSTANCE::isSupported)
                .map(Path::toAbsolutePath)
                .collect(Collectors.toList());

        final String playlistName = pathToPlaylistName();
        if (null == playlistName) {
            for (Path file : files) {
                System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
            }
            return;
        }
        System.out.printf("[DIFF] %s -> %s%n", directory, playlistName);
        final PLAYLIST playlist = nml().getPlaylist(playlistName);
        if (null == playlist) {
            for (Path file : files) {
                System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
            }
        } else {
            final PlaylistDiffResult diffResult = new PlaylistDiffBuilder(playlist).build(files);
            for (Path file : diffResult.notInFiles) {
                System.out.printf("[-] %s%n", file.toAbsolutePath().toString());
            }
            for (Path file : diffResult.notInPlaylist) {
                System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
            }
        }
    }

    private String pathToPlaylistName() {
        return FileHelper.normalizePath(directory).getFileName().toString();
    }
}
