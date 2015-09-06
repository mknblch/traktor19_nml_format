//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.09.05 um 08:37:16 PM CEST 
//


package de.mknblch.nml.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}HEAD"/>
 *         &lt;element ref="{}MUSICFOLDERS"/>
 *         &lt;element ref="{}COLLECTION"/>
 *         &lt;element ref="{}SETS"/>
 *         &lt;element ref="{}PLAYLISTS"/>
 *       &lt;/sequence>
 *       &lt;attribute name="VERSION" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "head",
    "musicfolders",
    "collection",
    "sets",
    "playlists"
})
@XmlRootElement(name = "NML")
public class NML {

    @XmlElement(name = "HEAD", required = true)
    protected HEAD head;
    @XmlElement(name = "MUSICFOLDERS", required = true)
    protected String musicfolders;
    @XmlElement(name = "COLLECTION", required = true)
    protected COLLECTION collection;
    @XmlElement(name = "SETS", required = true)
    protected SETS sets;
    @XmlElement(name = "PLAYLISTS", required = true)
    protected PLAYLISTS playlists;
    @XmlAttribute(name = "VERSION")
    protected Integer version;

    /**
     * Ruft den Wert der head-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HEAD }
     *     
     */
    public HEAD getHEAD() {
        return head;
    }

    /**
     * Legt den Wert der head-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HEAD }
     *     
     */
    public void setHEAD(HEAD value) {
        this.head = value;
    }

    /**
     * Ruft den Wert der musicfolders-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMUSICFOLDERS() {
        return musicfolders;
    }

    /**
     * Legt den Wert der musicfolders-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMUSICFOLDERS(String value) {
        this.musicfolders = value;
    }

    /**
     * Ruft den Wert der collection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link COLLECTION }
     *     
     */
    public COLLECTION getCOLLECTION() {
        return collection;
    }

    /**
     * Legt den Wert der collection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link COLLECTION }
     *     
     */
    public void setCOLLECTION(COLLECTION value) {
        this.collection = value;
    }

    /**
     * Ruft den Wert der sets-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SETS }
     *     
     */
    public SETS getSETS() {
        return sets;
    }

    /**
     * Legt den Wert der sets-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SETS }
     *     
     */
    public void setSETS(SETS value) {
        this.sets = value;
    }

    /**
     * Ruft den Wert der playlists-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PLAYLISTS }
     *     
     */
    public PLAYLISTS getPLAYLISTS() {
        return playlists;
    }

    /**
     * Legt den Wert der playlists-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PLAYLISTS }
     *     
     */
    public void setPLAYLISTS(PLAYLISTS value) {
        this.playlists = value;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVERSION() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVERSION(Integer value) {
        this.version = value;
    }

}
