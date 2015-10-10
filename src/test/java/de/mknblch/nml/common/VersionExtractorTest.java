package de.mknblch.nml.common;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 10.10.2015.
 */
public class VersionExtractorTest {

    @Test
    public void testGetCollectionVersion() throws Exception {

        final Path collectionPath = TraktorPathFinder.INSTANCE.getCollectionPath();
//        final Path collectionPath = Paths.get("C:/Users/mk/Desktop/test", "collection.nml");
        final String version = VersionExtractor.getCollectionVersion(collectionPath);
        System.out.println(version);
    }
}