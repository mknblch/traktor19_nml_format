package de.mknblch.nml.util;

import de.mknblch.nml.common.XMLSerializer;
import de.mknblch.nml.common.NMLDump;
import de.mknblch.nml.entities.*;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * Created by mknblch on 02.09.2015.
 */
public class DumpBuilderTest {

    private static XMLSerializer<NML> nmlBuilder;

    static {
        try {
            nmlBuilder = new XMLSerializer<>(NML.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {

        final NML nml = nmlBuilder.unmarshal(new File("C:/Users/mk/Desktop/musicbase.nml"));

        NMLDump.dump(nml);
    }

}