//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.22 at 10:48:59 AM CET 
//


package de.mknblch.nml.entities.traktor_19;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the playlist property.
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
     * Sets the value of the playlist property.
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
     * Gets the value of the subnodes property.
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
     * Sets the value of the subnodes property.
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
     * Gets the value of the type property.
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
     * Sets the value of the type property.
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
     * Gets the value of the name property.
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
     * Sets the value of the name property.
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
