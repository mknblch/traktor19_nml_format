package de.mknblch.nml.common;

import de.mknblch.nml.entities.ENTRY;
import de.mknblch.nml.entities.NML;
import de.mknblch.nml.entities.PRIMARYKEY;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by mknblch on 02.09.2015.
 */
public class XMLSerializer<T> {

    private final JAXBContext jaxbContext;
    private final Unmarshaller unmarshaller;
    private final Marshaller marshaller;

    public XMLSerializer(Class<T> clazz) throws JAXBException {

        jaxbContext = JAXBContext.newInstance(clazz);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
        marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    public T unmarshal(File file) throws JAXBException {
        return (T) unmarshaller.unmarshal(file);
    }

    public void marshal(T o, File out) throws JAXBException {
        marshaller.marshal(o, out);
    }
}
