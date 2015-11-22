package de.mknblch.nml.model.impl.traktor_19;

import de.mknblch.nml.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 22.11.2015.
 */
public class Traktor19Test {

    private Context context;

    @Before
    public void setup() throws ModelException {

        context = new ModelBuilder().build();
    }

    @Test
    public void test() throws Exception {

        context.getLibrary()
                .listPlaylists()
                .stream()
                .peek(this::printPlaylist)
                .map(Playlist::getTracks)
                .flatMap(List::stream)
                .forEach(this::printTrack);
    }

    private void printTrack(Track track) {

        if (track.isAnalyzed()) {
            System.out.printf("\t%s | %s - %s%n", track.getFileName(), track.getArtist(), track.getTitle());
        } else {
            System.out.printf("\t%s*%n", track.getFileName());
        }
    }

    private void printPlaylist(Playlist playlist) {
        System.out.printf("%s | %d songs%n", playlist.getName(), playlist.getTracks().size());
    }
    
}