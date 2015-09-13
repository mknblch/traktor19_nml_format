package de.mknblch.nml.common;

import de.mknblch.nml.entities.NML;
import de.mknblch.objectdump.ObjectDump;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.Pointer;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Paths;
import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by mknblch on 06.09.2015.
 */
public class NMLHelperTest {
    public static final String COLLECTION_X = "C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml";

    private static NML nml;
    private static JXPathContext context;

    @BeforeClass
    public static void setup() throws JAXBException {
        nml = new XMLSerializer<>(NML.class).unmarshal(new File(COLLECTION_X));
        context = JXPathContext.newContext(nml);

    }

    @Test
    public void test() throws Exception {
        dumpObj("/PLAYLISTS//NODE[@NAME!='$ROOT']/@NAME");
    }

//    @Test
    public void testRemovePlaylist() throws Exception {
        final NMLEditor editor = new NMLEditor(Paths.get(COLLECTION_X));
        editor.removePlaylists();
        editor.dump();
        editor.save();
    }

    public void dumpObj(String xpath) throws Exception {
        dump(context.selectNodes(xpath)); // !!!
    }

    @Test
    public void testGetPlaylistTracks() throws Exception {
        dumpObj("//NODE[@NAME='$ROOT']//ENTRY/CONTENT['PRIMARYKEY']");
    }

    @Test
    public void test2() throws Exception {
        dumpXpath("//NODE[@NAME='test']//ENTRY/CONTENT");
    }

    private void dumpXpath(String xpath) {
        final Iterator it = (Iterator<Pointer>)context.iteratePointers(xpath);
        while(it.hasNext()) {
            final Pointer pointer = (Pointer) it.next();
            System.out.println(pointer);
        }
    }

    @Test
    public void testUuid() throws Exception {
        System.out.println(NMLHelper.generateUUID());
    }

    private void dump(Object o) {

        ObjectDump.INSTANCE
                .setShowType(true)
                .reset()
                .scan(o)
                .printDump();
    }
    
}