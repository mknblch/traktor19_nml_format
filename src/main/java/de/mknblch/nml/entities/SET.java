//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.09.07 at 10:21:06 PM CEST 
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}LOCATION"/>
 *         &lt;element ref="{}MODIFICATION_INFO"/>
 *         &lt;element ref="{}INFO"/>
 *         &lt;element ref="{}TEMPO"/>
 *         &lt;element ref="{}SLOT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TITLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ARTIST" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="QUANT_VAlUE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="QUANT_STATE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "location",
    "modificationinfo",
    "info",
    "tempo",
    "slot"
})
@XmlRootElement(name = "SET")
public class SET {

    @XmlElement(name = "LOCATION", required = true)
    protected LOCATION location;
    @XmlElement(name = "MODIFICATION_INFO", required = true)
    protected MODIFICATIONINFO modificationinfo;
    @XmlElement(name = "INFO", required = true)
    protected INFO info;
    @XmlElement(name = "TEMPO", required = true)
    protected TEMPO tempo;
    @XmlElement(name = "SLOT")
    protected List<SLOT> slot;
    @XmlAttribute(name = "TITLE")
    protected String title;
    @XmlAttribute(name = "ARTIST")
    protected String artist;
    @XmlAttribute(name = "QUANT_VAlUE")
    protected Integer quantvAlUE;
    @XmlAttribute(name = "QUANT_STATE")
    protected Integer quantstate;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LOCATION }
     *     
     */
    public LOCATION getLOCATION() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LOCATION }
     *     
     */
    public void setLOCATION(LOCATION value) {
        this.location = value;
    }

    /**
     * Gets the value of the modificationinfo property.
     * 
     * @return
     *     possible object is
     *     {@link MODIFICATIONINFO }
     *     
     */
    public MODIFICATIONINFO getMODIFICATIONINFO() {
        return modificationinfo;
    }

    /**
     * Sets the value of the modificationinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MODIFICATIONINFO }
     *     
     */
    public void setMODIFICATIONINFO(MODIFICATIONINFO value) {
        this.modificationinfo = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link INFO }
     *     
     */
    public INFO getINFO() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link INFO }
     *     
     */
    public void setINFO(INFO value) {
        this.info = value;
    }

    /**
     * Gets the value of the tempo property.
     * 
     * @return
     *     possible object is
     *     {@link TEMPO }
     *     
     */
    public TEMPO getTEMPO() {
        return tempo;
    }

    /**
     * Sets the value of the tempo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEMPO }
     *     
     */
    public void setTEMPO(TEMPO value) {
        this.tempo = value;
    }

    /**
     * Gets the value of the slot property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slot property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSLOT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SLOT }
     * 
     * 
     */
    public List<SLOT> getSLOT() {
        if (slot == null) {
            slot = new ArrayList<SLOT>();
        }
        return this.slot;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTITLE() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTITLE(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the artist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getARTIST() {
        return artist;
    }

    /**
     * Sets the value of the artist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setARTIST(String value) {
        this.artist = value;
    }

    /**
     * Gets the value of the quantvAlUE property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQUANTVAlUE() {
        return quantvAlUE;
    }

    /**
     * Sets the value of the quantvAlUE property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQUANTVAlUE(Integer value) {
        this.quantvAlUE = value;
    }

    /**
     * Gets the value of the quantstate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getQUANTSTATE() {
        return quantstate;
    }

    /**
     * Sets the value of the quantstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setQUANTSTATE(Integer value) {
        this.quantstate = value;
    }

}
