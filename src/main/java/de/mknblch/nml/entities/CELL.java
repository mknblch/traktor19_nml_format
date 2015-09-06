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
 *       &lt;attribute name="INDEX" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="CELLNAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="COLOR" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SYNC" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="REVERSE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="MODE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TYPE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="SPEED" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TRANSPOSE" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="OFFSET" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="NUDGE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="GAIN" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="START_MARKER" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="END_MARKER" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="BPM" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="DIR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FILE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VOLUME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "CELL")
public class CELL {

    @XmlAttribute(name = "INDEX")
    protected Integer index;
    @XmlAttribute(name = "CELLNAME")
    protected String cellname;
    @XmlAttribute(name = "COLOR")
    protected Integer color;
    @XmlAttribute(name = "SYNC")
    protected Integer sync;
    @XmlAttribute(name = "REVERSE")
    protected Integer reverse;
    @XmlAttribute(name = "MODE")
    protected Integer mode;
    @XmlAttribute(name = "TYPE")
    protected Integer type;
    @XmlAttribute(name = "SPEED")
    protected Integer speed;
    @XmlAttribute(name = "TRANSPOSE")
    protected Double transpose;
    @XmlAttribute(name = "OFFSET")
    protected Double offset;
    @XmlAttribute(name = "NUDGE")
    protected Integer nudge;
    @XmlAttribute(name = "GAIN")
    protected Double gain;
    @XmlAttribute(name = "START_MARKER")
    protected Integer startmarker;
    @XmlAttribute(name = "END_MARKER")
    protected Integer endmarker;
    @XmlAttribute(name = "BPM")
    protected Double bpm;
    @XmlAttribute(name = "DIR")
    protected String dir;
    @XmlAttribute(name = "FILE")
    protected String file;
    @XmlAttribute(name = "VOLUME")
    protected String volume;

    /**
     * Ruft den Wert der index-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getINDEX() {
        return index;
    }

    /**
     * Legt den Wert der index-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setINDEX(Integer value) {
        this.index = value;
    }

    /**
     * Ruft den Wert der cellname-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCELLNAME() {
        return cellname;
    }

    /**
     * Legt den Wert der cellname-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCELLNAME(String value) {
        this.cellname = value;
    }

    /**
     * Ruft den Wert der color-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCOLOR() {
        return color;
    }

    /**
     * Legt den Wert der color-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCOLOR(Integer value) {
        this.color = value;
    }

    /**
     * Ruft den Wert der sync-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSYNC() {
        return sync;
    }

    /**
     * Legt den Wert der sync-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSYNC(Integer value) {
        this.sync = value;
    }

    /**
     * Ruft den Wert der reverse-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getREVERSE() {
        return reverse;
    }

    /**
     * Legt den Wert der reverse-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setREVERSE(Integer value) {
        this.reverse = value;
    }

    /**
     * Ruft den Wert der mode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMODE() {
        return mode;
    }

    /**
     * Legt den Wert der mode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMODE(Integer value) {
        this.mode = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTYPE() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTYPE(Integer value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der speed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSPEED() {
        return speed;
    }

    /**
     * Legt den Wert der speed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSPEED(Integer value) {
        this.speed = value;
    }

    /**
     * Ruft den Wert der transpose-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTRANSPOSE() {
        return transpose;
    }

    /**
     * Legt den Wert der transpose-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTRANSPOSE(Double value) {
        this.transpose = value;
    }

    /**
     * Ruft den Wert der offset-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOFFSET() {
        return offset;
    }

    /**
     * Legt den Wert der offset-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOFFSET(Double value) {
        this.offset = value;
    }

    /**
     * Ruft den Wert der nudge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNUDGE() {
        return nudge;
    }

    /**
     * Legt den Wert der nudge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNUDGE(Integer value) {
        this.nudge = value;
    }

    /**
     * Ruft den Wert der gain-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getGAIN() {
        return gain;
    }

    /**
     * Legt den Wert der gain-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setGAIN(Double value) {
        this.gain = value;
    }

    /**
     * Ruft den Wert der startmarker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSTARTMARKER() {
        return startmarker;
    }

    /**
     * Legt den Wert der startmarker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSTARTMARKER(Integer value) {
        this.startmarker = value;
    }

    /**
     * Ruft den Wert der endmarker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getENDMARKER() {
        return endmarker;
    }

    /**
     * Legt den Wert der endmarker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setENDMARKER(Integer value) {
        this.endmarker = value;
    }

    /**
     * Ruft den Wert der bpm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBPM() {
        return bpm;
    }

    /**
     * Legt den Wert der bpm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBPM(Double value) {
        this.bpm = value;
    }

    /**
     * Ruft den Wert der dir-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIR() {
        return dir;
    }

    /**
     * Legt den Wert der dir-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIR(String value) {
        this.dir = value;
    }

    /**
     * Ruft den Wert der file-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFILE() {
        return file;
    }

    /**
     * Legt den Wert der file-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFILE(String value) {
        this.file = value;
    }

    /**
     * Ruft den Wert der volume-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVOLUME() {
        return volume;
    }

    /**
     * Legt den Wert der volume-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVOLUME(String value) {
        this.volume = value;
    }

}
