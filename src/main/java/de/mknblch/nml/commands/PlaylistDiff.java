package de.mknblch.nml.commands;

import de.mknblch.nml.common.PlaylistDiffBuilder;
import de.mknblch.nml.common.PlaylistDiffResult;
import de.mknblch.nml.common.TypeHelper;
import de.mknblch.nml.entities.PLAYLIST;
import de.mknblch.params.annotations.Argument;
import de.mknblch.params.annotations.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mknblch on 13.09.2015.
 */
@Command(trigger = "playlist", sub = "diff", description = "Print diff between directory and playlist")
public class PlaylistDiff extends WithCollection implements Runnable {

    @Argument(trigger = "-d", description = "Path to directory")
    private Path directory;

    @Override
    public void run() {

        try {
            final List<Path> files = Files.walk(directory)
                    .filter(TypeHelper.INSTANCE::isSupported)
                    .map(Path::toAbsolutePath)
//                    .map(p -> Paths.get(p.toString().replaceAll("\\\\", "/")))
                    .collect(Collectors.toList());

            final String playlistName = directory.toAbsolutePath().getFileName().toString();
            if (null == playlistName) {
                for (Path file : files) {
                    System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
                }
                return;
            }
            final PLAYLIST playlist = getEditor().getPlaylist(playlistName);
            final PlaylistDiffResult diffResult = new PlaylistDiffBuilder(playlist).build(files);

            for (Path file : diffResult.notInPlaylist) {
                System.out.printf("[+] %s%n", file.toAbsolutePath().toString());
            }
            for (Path file : diffResult.notInFiles) {
                System.out.printf("[-] %s%n", file.toAbsolutePath().toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
