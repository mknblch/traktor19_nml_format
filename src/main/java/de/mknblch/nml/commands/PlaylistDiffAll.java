package de.mknblch.nml.commands;

import de.mknblch.nml.common.FileHelper;
import de.mknblch.nml.common.TypeHelper;
import de.mknblch.nml.diff.PlaylistDiffBuilder;
import de.mknblch.nml.diff.PlaylistDiffResult;
import de.mknblch.nml.entities.traktor.v2_9_1.PLAYLIST;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;
import de.mknblch.params.annotations.Description;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 13.09.2015.
 */
@Description("Treats every subdirectory as playlist and show diff")
@Command(trigger = {"playlist", "diffall"})
public class PlaylistDiffAll extends TraktorCollection implements Runnable {

    @Description("Path to directory")
    @Argument(trigger = "--directory", alt = "-d")
    private Path directory;

    @Override
    public void run() {
        try {
            System.out.printf("[DIFFALL] %s%n", directory);
            FileHelper.fetchSubdirectories(directory)
                    .forEach(this::diff);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void diff(Path directory) {
        try {

            final List<Path> files = Files.walk(directory)
                    .map(FileHelper::normalizePath)
                    .filter(TypeHelper.INSTANCE::isSupported)
                    .collect(Collectors.toList());

            final String playlistName = pathToPlaylistName(directory);
            if (null == playlistName) {
                for (Path file : files) {
                    System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
                }
                return;
            }

            int newFiles = 0, removedFiles = 0;

            System.out.printf("[DIFF] %s -> %s%n", directory, playlistName);
            final PLAYLIST playlist = nml().getPlaylist(playlistName);
            if (null == playlist) {
                for (Path file : files) {
                    System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
                }
                newFiles = files.size();
            } else {
                final PlaylistDiffResult diffResult = new PlaylistDiffBuilder(playlist).build(files);
                for (Path file : diffResult.notInFiles) {
                    System.out.printf("[-] %s%n", file.toAbsolutePath().toString());
                }
                removedFiles = diffResult.notInFiles.size();
                for (Path file : diffResult.notInPlaylist) {
                    System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
                }
                newFiles = diffResult.notInPlaylist.size();
            }

            System.out.printf("[%d new | %d removed]%n",
                    newFiles, removedFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String pathToPlaylistName(Path directory) {
        return FileHelper.normalizePath(directory).getFileName().toString();
    }
}
