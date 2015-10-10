//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.10.10 at 06:29:22 PM CEST 
//


package de.mknblch.nml.entities.traktor_19;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.mknblch.nml.entities.traktor_19 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MUSICFOLDERS_QNAME = new QName("", "MUSICFOLDERS");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.mknblch.nml.entities.traktor_19
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LOCATION }
     * 
     */
    public LOCATION createLOCATION() {
        return new LOCATION();
    }

    /**
     * Create an instance of {@link PLAYLISTS }
     * 
     */
    public PLAYLISTS createPLAYLISTS() {
        return new PLAYLISTS();
    }

    /**
     * Create an instance of {@link NODE }
     * 
     */
    public NODE createNODE() {
        return new NODE();
    }

    /**
     * Create an instance of {@link PLAYLIST }
     * 
     */
    public PLAYLIST createPLAYLIST() {
        return new PLAYLIST();
    }

    /**
     * Create an instance of {@link ENTRY }
     * 
     */
    public ENTRY createENTRY() {
        return new ENTRY();
    }

    /**
     * Create an instance of {@link MODIFICATIONINFO }
     * 
     */
    public MODIFICATIONINFO createMODIFICATIONINFO() {
        return new MODIFICATIONINFO();
    }

    /**
     * Create an instance of {@link INFO }
     * 
     */
    public INFO createINFO() {
        return new INFO();
    }

    /**
     * Create an instance of {@link TEMPO }
     * 
     */
    public TEMPO createTEMPO() {
        return new TEMPO();
    }

    /**
     * Create an instance of {@link LOUDNESS }
     * 
     */
    public LOUDNESS createLOUDNESS() {
        return new LOUDNESS();
    }

    /**
     * Create an instance of {@link CUEV2 }
     * 
     */
    public CUEV2 createCUEV2() {
        return new CUEV2();
    }

    /**
     * Create an instance of {@link MUSICALKEY }
     * 
     */
    public MUSICALKEY createMUSICALKEY() {
        return new MUSICALKEY();
    }

    /**
     * Create an instance of {@link ALBUM }
     * 
     */
    public ALBUM createALBUM() {
        return new ALBUM();
    }

    /**
     * Create an instance of {@link PRIMARYKEY }
     * 
     */
    public PRIMARYKEY createPRIMARYKEY() {
        return new PRIMARYKEY();
    }

    /**
     * Create an instance of {@link SUBNODES }
     * 
     */
    public SUBNODES createSUBNODES() {
        return new SUBNODES();
    }

    /**
     * Create an instance of {@link HEAD }
     * 
     */
    public HEAD createHEAD() {
        return new HEAD();
    }

    /**
     * Create an instance of {@link COLLECTION }
     * 
     */
    public COLLECTION createCOLLECTION() {
        return new COLLECTION();
    }

    /**
     * Create an instance of {@link SET }
     * 
     */
    public SET createSET() {
        return new SET();
    }

    /**
     * Create an instance of {@link SLOT }
     * 
     */
    public SLOT createSLOT() {
        return new SLOT();
    }

    /**
     * Create an instance of {@link CELL }
     * 
     */
    public CELL createCELL() {
        return new CELL();
    }

    /**
     * Create an instance of {@link NML }
     * 
     */
    public NML createNML() {
        return new NML();
    }

    /**
     * Create an instance of {@link SETS }
     * 
     */
    public SETS createSETS() {
        return new SETS();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MUSICFOLDERS")
    public JAXBElement<String> createMUSICFOLDERS(String value) {
        return new JAXBElement<String>(_MUSICFOLDERS_QNAME, String.class, null, value);
    }

}