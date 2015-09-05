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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}LOCATION" minOccurs="0"/>
 *         &lt;element ref="{}ALBUM" minOccurs="0"/>
 *         &lt;element ref="{}MODIFICATION_INFO" minOccurs="0"/>
 *         &lt;element ref="{}INFO" minOccurs="0"/>
 *         &lt;element ref="{}TEMPO" minOccurs="0"/>
 *         &lt;element ref="{}LOUDNESS" minOccurs="0"/>
 *         &lt;element ref="{}MUSICAL_KEY" minOccurs="0"/>
 *         &lt;element ref="{}LOOPINFO" minOccurs="0"/>
 *         &lt;element ref="{}CUE_V2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}PRIMARYKEY" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="MODIFIED_DATE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="MODIFIED_TIME" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="AUDIO_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TITLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ARTIST" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LOCK" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="LOCK_MODIFICATION_TIME" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
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
    "album",
    "modificationinfo",
    "info",
    "tempo",
    "loudness",
    "musicalkey",
    "loopinfo",
    "cuev2",
    "primarykey"
})
@XmlRootElement(name = "ENTRY")
public class ENTRY {

    @XmlElement(name = "LOCATION")
    protected LOCATION location;
    @XmlElement(name = "ALBUM")
    protected ALBUM album;
    @XmlElement(name = "MODIFICATION_INFO")
    protected MODIFICATIONINFO modificationinfo;
    @XmlElement(name = "INFO")
    protected INFO info;
    @XmlElement(name = "TEMPO")
    protected TEMPO tempo;
    @XmlElement(name = "LOUDNESS")
    protected LOUDNESS loudness;
    @XmlElement(name = "MUSICAL_KEY")
    protected MUSICALKEY musicalkey;
    @XmlElement(name = "LOOPINFO")
    protected LOOPINFO loopinfo;
    @XmlElement(name = "CUE_V2")
    protected List<CUEV2> cuev2;
    @XmlElement(name = "PRIMARYKEY")
    protected PRIMARYKEY primarykey;
    @XmlAttribute(name = "MODIFIED_DATE")
    protected String modifieddate;
    @XmlAttribute(name = "MODIFIED_TIME")
    protected Integer modifiedtime;
    @XmlAttribute(name = "AUDIO_ID")
    protected String audioid;
    @XmlAttribute(name = "TITLE")
    protected String title;
    @XmlAttribute(name = "ARTIST")
    protected String artist;
    @XmlAttribute(name = "LOCK")
    protected Byte lock;
    @XmlAttribute(name = "LOCK_MODIFICATION_TIME")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lockmodificationtime;

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
     * Ruft den Wert der album-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ALBUM }
     *     
     */
    public ALBUM getALBUM() {
        return album;
    }

    /**
     * Legt den Wert der album-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ALBUM }
     *     
     */
    public void setALBUM(ALBUM value) {
        this.album = value;
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
     * Ruft den Wert der loudness-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LOUDNESS }
     *     
     */
    public LOUDNESS getLOUDNESS() {
        return loudness;
    }

    /**
     * Legt den Wert der loudness-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LOUDNESS }
     *     
     */
    public void setLOUDNESS(LOUDNESS value) {
        this.loudness = value;
    }

    /**
     * Ruft den Wert der musicalkey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MUSICALKEY }
     *     
     */
    public MUSICALKEY getMUSICALKEY() {
        return musicalkey;
    }

    /**
     * Legt den Wert der musicalkey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MUSICALKEY }
     *     
     */
    public void setMUSICALKEY(MUSICALKEY value) {
        this.musicalkey = value;
    }

    /**
     * Ruft den Wert der loopinfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LOOPINFO }
     *     
     */
    public LOOPINFO getLOOPINFO() {
        return loopinfo;
    }

    /**
     * Legt den Wert der loopinfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LOOPINFO }
     *     
     */
    public void setLOOPINFO(LOOPINFO value) {
        this.loopinfo = value;
    }

    /**
     * Gets the value of the cuev2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuev2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCUEV2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CUEV2 }
     * 
     * 
     */
    public List<CUEV2> getCUEV2() {
        if (cuev2 == null) {
            cuev2 = new ArrayList<CUEV2>();
        }
        return this.cuev2;
    }

    /**
     * Ruft den Wert der primarykey-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PRIMARYKEY }
     *     
     */
    public PRIMARYKEY getPRIMARYKEY() {
        return primarykey;
    }

    /**
     * Legt den Wert der primarykey-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PRIMARYKEY }
     *     
     */
    public void setPRIMARYKEY(PRIMARYKEY value) {
        this.primarykey = value;
    }

    /**
     * Ruft den Wert der modifieddate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODIFIEDDATE() {
        return modifieddate;
    }

    /**
     * Legt den Wert der modifieddate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODIFIEDDATE(String value) {
        this.modifieddate = value;
    }

    /**
     * Ruft den Wert der modifiedtime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMODIFIEDTIME() {
        return modifiedtime;
    }

    /**
     * Legt den Wert der modifiedtime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMODIFIEDTIME(Integer value) {
        this.modifiedtime = value;
    }

    /**
     * Ruft den Wert der audioid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUDIOID() {
        return audioid;
    }

    /**
     * Legt den Wert der audioid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUDIOID(String value) {
        this.audioid = value;
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
     * Ruft den Wert der lock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getLOCK() {
        return lock;
    }

    /**
     * Legt den Wert der lock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setLOCK(Byte value) {
        this.lock = value;
    }

    /**
     * Ruft den Wert der lockmodificationtime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLOCKMODIFICATIONTIME() {
        return lockmodificationtime;
    }

    /**
     * Legt den Wert der lockmodificationtime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLOCKMODIFICATIONTIME(XMLGregorianCalendar value) {
        this.lockmodificationtime = value;
    }

}
