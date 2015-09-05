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
 *       &lt;attribute name="PERCEIVED_DB" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="PEAK_DB" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="ANALYZED_DB" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "LOUDNESS")
public class LOUDNESS {

    @XmlAttribute(name = "PERCEIVED_DB")
    protected Float perceiveddb;
    @XmlAttribute(name = "PEAK_DB")
    protected Float peakdb;
    @XmlAttribute(name = "ANALYZED_DB")
    protected Float analyzeddb;

    /**
     * Ruft den Wert der perceiveddb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPERCEIVEDDB() {
        return perceiveddb;
    }

    /**
     * Legt den Wert der perceiveddb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPERCEIVEDDB(Float value) {
        this.perceiveddb = value;
    }

    /**
     * Ruft den Wert der peakdb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getPEAKDB() {
        return peakdb;
    }

    /**
     * Legt den Wert der peakdb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setPEAKDB(Float value) {
        this.peakdb = value;
    }

    /**
     * Ruft den Wert der analyzeddb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getANALYZEDDB() {
        return analyzeddb;
    }

    /**
     * Legt den Wert der analyzeddb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setANALYZEDDB(Float value) {
        this.analyzeddb = value;
    }

}
