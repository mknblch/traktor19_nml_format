package de.mknblch.nml.common;

import de.mknblch.nml.entities.traktor_2_9_1.NML;
import de.mknblch.nml.mediator.NMLHelper;
import de.mknblch.nml.mediator.NMLMediator;
import de.mknblch.nml.mediator.XMLSerializer;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.nio.file.Paths;

/**
 * Created by mknblch on 06.09.2015.
 */
public class NMLHelperTest {
    public static final String COLLECTION_X = "C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml";

    private static NML nml;

    @BeforeClass
    public static void setup() throws JAXBException {
        nml = new XMLSerializer<>(NML.class).unmarshal(new File(COLLECTION_X));
    }


//    @Test
    public void testRemovePlaylist() throws Exception {
        final NMLMediator editor = new NMLMediator(Paths.get(COLLECTION_X));
        editor.removePlaylists();
        editor.save();
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