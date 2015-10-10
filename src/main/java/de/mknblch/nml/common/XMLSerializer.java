package de.mknblch.nml.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by mknblch on 02.09.2015.
 */
public class XMLSerializer<T> {

    private final Unmarshaller unmarshaller;
    private final Marshaller marshaller;

    public XMLSerializer(Class<T> clazz, boolean standalone) throws JAXBException {

        final JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

        marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        if (standalone) {
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        }
        unmarshaller = jaxbContext.createUnmarshaller();
    }

    public T unmarshal(File file) throws JAXBException {
        return (T) unmarshaller.unmarshal(file);
    }

    public void marshal(T o, File out) throws JAXBException {
        marshaller.marshal(o, out);
    }
}
