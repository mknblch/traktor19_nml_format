package de.mknblch.nml;

import de.mknblch.nml.common.NMLEditor;
import de.mknblch.nml.common.XMLSerializer;
import de.mknblch.nml.entities.NML;
import de.mknblch.objectdump.ObjectDump;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;

import java.io.File;

/**
 * Created by mknblch on 05.09.2015.
 */
public class NMLEditorTest {

    public static final String COLLECTION_X = "C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml";
    public static final String COLLECTION_A = "C:/Users/mk/Desktop/collection.nml";

    private static NMLEditor editor;
    private static NML nml;

    @BeforeClass
    public static void setup() throws JAXBException {
        nml = new XMLSerializer<>(NML.class).unmarshal(new File(COLLECTION_X));
        editor = new NMLEditor(nml);
    }

    @Test
    public void testGetPlaylistNode() throws Exception {


        dump(editor.getPlaylistNode("Demo Tracks"));

    }

    @Test
    public void testGetPlaylistKeys() throws Exception {

        dump(editor.getPlaylistFiles("$ROOT"));
//        dump(editor.getPlaylistFiles("TOOLS"));

    }

    @Test
    public void testRoot() throws Exception {

        dump(editor.getPlaylistNode("$ROOT"));
    }

    private void dump(Object o) {

        ObjectDump.INSTANCE
                .setShowType(true)
                .reset()
                .scan(o)
                .printDump();
    }
}