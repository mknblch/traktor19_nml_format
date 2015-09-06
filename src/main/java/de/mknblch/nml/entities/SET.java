//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.09.05 um 08:37:16 PM CEST 
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
     * Ruft den Wert der location-Eigenschaft ab.
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
     * Legt den Wert der location-Eigenschaft fest.
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
     * Ruft den Wert der modificationinfo-Eigenschaft ab.
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
     * Legt den Wert der modificationinfo-Eigenschaft fest.
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
     * Ruft den Wert der info-Eigenschaft ab.
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
     * Legt den Wert der info-Eigenschaft fest.
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
     * Ruft den Wert der tempo-Eigenschaft ab.
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
     * Legt den Wert der tempo-Eigenschaft fest.
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
     * Ruft den Wert der title-Eigenschaft ab.
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
     * Legt den Wert der title-Eigenschaft fest.
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
     * Ruft den Wert der artist-Eigenschaft ab.
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
     * Legt den Wert der artist-Eigenschaft fest.
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
     * Ruft den Wert der quantvAlUE-Eigenschaft ab.
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
     * Legt den Wert der quantvAlUE-Eigenschaft fest.
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
     * Ruft den Wert der quantstate-Eigenschaft ab.
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
     * Legt den Wert der quantstate-Eigenschaft fest.
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
