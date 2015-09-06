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
 *         &lt;element ref="{}PLAYLIST" minOccurs="0"/>
 *         &lt;element ref="{}SUBNODES" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TYPE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "playlist",
    "subnodes"
})
@XmlRootElement(name = "NODE")
public class NODE {

    @XmlElement(name = "PLAYLIST")
    protected PLAYLIST playlist;
    @XmlElement(name = "SUBNODES")
    protected SUBNODES subnodes;
    @XmlAttribute(name = "TYPE")
    protected String type;
    @XmlAttribute(name = "NAME")
    protected String name;

    /**
     * Ruft den Wert der playlist-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PLAYLIST }
     *     
     */
    public PLAYLIST getPLAYLIST() {
        return playlist;
    }

    /**
     * Legt den Wert der playlist-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PLAYLIST }
     *     
     */
    public void setPLAYLIST(PLAYLIST value) {
        this.playlist = value;
    }

    /**
     * Ruft den Wert der subnodes-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SUBNODES }
     *     
     */
    public SUBNODES getSUBNODES() {
        return subnodes;
    }

    /**
     * Legt den Wert der subnodes-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SUBNODES }
     *     
     */
    public void setSUBNODES(SUBNODES value) {
        this.subnodes = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTYPE() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTYPE(String value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

}
