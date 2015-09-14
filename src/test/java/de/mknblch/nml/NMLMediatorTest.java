package de.mknblch.nml;

import de.mknblch.nml.common.NMLMediator;
import de.mknblch.nml.entities.ENTRY;
import de.mknblch.nml.entities.PRIMARYKEY;
import de.mknblch.objectdump.ObjectDump;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by mknblch on 05.09.2015.
 */
public class NMLMediatorTest {

    public static final String COLLECTION_X = "C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml";
    public static final String COLLECTION_A = "C:/Users/mk/Desktop/collection.nml";

    private static NMLMediator editor;

    @BeforeClass
    public static void setup() throws JAXBException {
        editor = new NMLMediator(Paths.get(COLLECTION_X));
    }

    @Test
    public void test() throws Exception {

        dump(editor.selectMany(("/PLAYLISTS//NODE[@NAME='test']//ENTRY/CONTENT['PRIMARYKEY'][@TYPE='TRACK' and @KEY='D:/:deleted/:Always There.mp3']/.."), Object.class));
    }

    @Test
    public void testVolumeId() throws Exception {

        dump(editor.findVolumeId("D:"));
    }

//    @Test
    public void testAddEntry() throws Exception {

        final Path path = Paths.get("D:/music/tools/jackson_5-i_want_you_back (Accapella - Acapella - Vocals).mp3");

        assertTrue(Files.exists(path));

        final ENTRY entry = editor.addOrGetCollectionEntry(path);

        editor.addToPlaylist("foo", entry);

        dump(editor.getNml());

        save();
    }

    private void save() throws JAXBException {
        editor.save();
    }

//    @Test
    public void testGetPlaylistKeys() throws Exception {

        final List<PRIMARYKEY> keys = editor.getPlaylistPrimaryKeys("$ROOT");
        assertFalse(keys.isEmpty());
        dump(keys);
    }

    @Test
    public void testRemove() throws Exception {

        editor.removeFromPlaylists("D:/:deleted/:Always There.mp3");
        dump(editor.getNml());
        save();
    }

    private void dump(Object o) {

        ObjectDump.INSTANCE
                .setShowType(true)
                .reset()
                .scan(o)
                .printDump();
    }
}