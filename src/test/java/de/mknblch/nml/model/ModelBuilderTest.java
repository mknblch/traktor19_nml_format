package de.mknblch.nml.model;

import de.mknblch.nml.model.impl.traktor_19.Traktor19;
import de.mknblch.nml.model.impl.traktor_19.TraktorLibrary;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 11.10.2015.
 */
public class ModelBuilderTest {

    @Test
    public void testBuildContext() throws Exception {

        Path path = Paths.get("C:/Users/mk/Desktop/test/collection.nml");

        final Traktor19 build = (Traktor19) new ModelBuilder()
                .build(path);

        final Library library = build.getLibrary();

        assertNotNull(library);
    }
    
    @Test
    public void testGetTracks() throws Exception {

        final Traktor19 build = (Traktor19) new ModelBuilder()
                .build();

        final Library library = build.getLibrary();

        final List<Track> tracks = library.listTracks();
    
        for (Track track : tracks) {
            System.out.println(track);
        }
    
        System.out.println(tracks.size());
    }
    
}