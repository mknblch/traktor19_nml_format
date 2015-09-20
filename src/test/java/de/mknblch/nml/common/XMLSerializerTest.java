package de.mknblch.nml.common;

import de.mknblch.nml.entities.NML;
import de.mknblch.nml.mediator.NMLSerializer;
import org.junit.Test;

import java.io.File;

/**
 * Created by mknblch on 07.09.2015.
 */
public class XMLSerializerTest {

    public static final String COLLECTION_A = "C:/Users/mk/Desktop/collection.nml";

    public static final String COLLECTION_X = "C:\\Users\\mk\\Documents\\Native Instruments\\Traktor 2.9.0\\collection.nml";

    @Test
    public void testLoadAndSave() throws Exception {

        final NMLSerializer<NML> serializer = new NMLSerializer<>(NML.class);

        final NML nml = serializer.unmarshal(new File(COLLECTION_X));

//        serializer.marshal(nml, new File(COLLECTION_X));



    }
    
}