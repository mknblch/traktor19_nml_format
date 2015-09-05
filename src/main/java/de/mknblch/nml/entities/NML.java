//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.08.24 um 11:28:02 AM CEST 
//


package de.mknblch.nml.entities;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{}SORTING_ORDER" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="VERSION" type="{http://www.w3.org/2001/XMLSchema}byte" />
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
    "playlists",
    "sortingorder"
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
    @XmlElement(name = "SORTING_ORDER")
    protected List<SORTINGORDER> sortingorder;
    @XmlAttribute(name = "VERSION")
    protected Byte version;

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
     * Gets the value of the sortingorder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sortingorder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSORTINGORDER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SORTINGORDER }
     * 
     * 
     */
    public List<SORTINGORDER> getSORTINGORDER() {
        if (sortingorder == null) {
            sortingorder = new ArrayList<SORTINGORDER>();
        }
        return this.sortingorder;
    }

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getVERSION() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setVERSION(Byte value) {
        this.version = value;
    }

}
