//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.08.24 um 11:28:02 AM CEST 
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
 *       &lt;attribute name="ORIGINAL_TITLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ORIGINAL_TRACKID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ORIGINAL_LOOP_SIZE" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="ORIGINAL_LOOP_START" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="SAMPLE_TYPE_INFO" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "LOOPINFO")
public class LOOPINFO {

    @XmlAttribute(name = "ORIGINAL_TITLE")
    protected String originaltitle;
    @XmlAttribute(name = "ORIGINAL_TRACKID")
    protected String originaltrackid;
    @XmlAttribute(name = "ORIGINAL_LOOP_SIZE")
    protected Float originalloopsize;
    @XmlAttribute(name = "ORIGINAL_LOOP_START")
    protected Byte originalloopstart;
    @XmlAttribute(name = "SAMPLE_TYPE_INFO")
    protected Byte sampletypeinfo;

    /**
     * Ruft den Wert der originaltitle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINALTITLE() {
        return originaltitle;
    }

    /**
     * Legt den Wert der originaltitle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINALTITLE(String value) {
        this.originaltitle = value;
    }

    /**
     * Ruft den Wert der originaltrackid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINALTRACKID() {
        return originaltrackid;
    }

    /**
     * Legt den Wert der originaltrackid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINALTRACKID(String value) {
        this.originaltrackid = value;
    }

    /**
     * Ruft den Wert der originalloopsize-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getORIGINALLOOPSIZE() {
        return originalloopsize;
    }

    /**
     * Legt den Wert der originalloopsize-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setORIGINALLOOPSIZE(Float value) {
        this.originalloopsize = value;
    }

    /**
     * Ruft den Wert der originalloopstart-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getORIGINALLOOPSTART() {
        return originalloopstart;
    }

    /**
     * Legt den Wert der originalloopstart-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setORIGINALLOOPSTART(Byte value) {
        this.originalloopstart = value;
    }

    /**
     * Ruft den Wert der sampletypeinfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getSAMPLETYPEINFO() {
        return sampletypeinfo;
    }

    /**
     * Legt den Wert der sampletypeinfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setSAMPLETYPEINFO(Byte value) {
        this.sampletypeinfo = value;
    }

}
