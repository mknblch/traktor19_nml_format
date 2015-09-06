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
 *       &lt;attribute name="BITRATE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="GENRE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="COMMENT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="COVERARTID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="PLAYTIME" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PLAYTIME_FLOAT" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="IMPORT_DATE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="RELEASE_DATE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FLAGS" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="FILESIZE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="LABEL" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="KEY" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LAST_PLAYED" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "INFO")
public class INFO {

    @XmlAttribute(name = "BITRATE")
    protected Integer bitrate;
    @XmlAttribute(name = "GENRE")
    protected String genre;
    @XmlAttribute(name = "COMMENT")
    protected String comment;
    @XmlAttribute(name = "COVERARTID")
    protected String coverartid;
    @XmlAttribute(name = "PLAYTIME")
    protected Integer playtime;
    @XmlAttribute(name = "PLAYTIME_FLOAT")
    protected Double playtimefloat;
    @XmlAttribute(name = "IMPORT_DATE")
    protected String importdate;
    @XmlAttribute(name = "RELEASE_DATE")
    protected String releasedate;
    @XmlAttribute(name = "FLAGS")
    protected Integer flags;
    @XmlAttribute(name = "FILESIZE")
    protected Integer filesize;
    @XmlAttribute(name = "LABEL")
    protected String label;
    @XmlAttribute(name = "KEY")
    protected String key;
    @XmlAttribute(name = "LAST_PLAYED")
    protected String lastplayed;

    /**
     * Ruft den Wert der bitrate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBITRATE() {
        return bitrate;
    }

    /**
     * Legt den Wert der bitrate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBITRATE(Integer value) {
        this.bitrate = value;
    }

    /**
     * Ruft den Wert der genre-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGENRE() {
        return genre;
    }

    /**
     * Legt den Wert der genre-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGENRE(String value) {
        this.genre = value;
    }

    /**
     * Ruft den Wert der comment-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMENT() {
        return comment;
    }

    /**
     * Legt den Wert der comment-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMENT(String value) {
        this.comment = value;
    }

    /**
     * Ruft den Wert der coverartid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOVERARTID() {
        return coverartid;
    }

    /**
     * Legt den Wert der coverartid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOVERARTID(String value) {
        this.coverartid = value;
    }

    /**
     * Ruft den Wert der playtime-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPLAYTIME() {
        return playtime;
    }

    /**
     * Legt den Wert der playtime-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPLAYTIME(Integer value) {
        this.playtime = value;
    }

    /**
     * Ruft den Wert der playtimefloat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPLAYTIMEFLOAT() {
        return playtimefloat;
    }

    /**
     * Legt den Wert der playtimefloat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPLAYTIMEFLOAT(Double value) {
        this.playtimefloat = value;
    }

    /**
     * Ruft den Wert der importdate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMPORTDATE() {
        return importdate;
    }

    /**
     * Legt den Wert der importdate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMPORTDATE(String value) {
        this.importdate = value;
    }

    /**
     * Ruft den Wert der releasedate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELEASEDATE() {
        return releasedate;
    }

    /**
     * Legt den Wert der releasedate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELEASEDATE(String value) {
        this.releasedate = value;
    }

    /**
     * Ruft den Wert der flags-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFLAGS() {
        return flags;
    }

    /**
     * Legt den Wert der flags-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFLAGS(Integer value) {
        this.flags = value;
    }

    /**
     * Ruft den Wert der filesize-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFILESIZE() {
        return filesize;
    }

    /**
     * Legt den Wert der filesize-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFILESIZE(Integer value) {
        this.filesize = value;
    }

    /**
     * Ruft den Wert der label-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLABEL() {
        return label;
    }

    /**
     * Legt den Wert der label-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLABEL(String value) {
        this.label = value;
    }

    /**
     * Ruft den Wert der key-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKEY() {
        return key;
    }

    /**
     * Legt den Wert der key-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKEY(String value) {
        this.key = value;
    }

    /**
     * Ruft den Wert der lastplayed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTPLAYED() {
        return lastplayed;
    }

    /**
     * Legt den Wert der lastplayed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTPLAYED(String value) {
        this.lastplayed = value;
    }

}
