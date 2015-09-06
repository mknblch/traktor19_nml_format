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
 *       &lt;attribute name="PEAK_DB" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="PERCEIVED_DB" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="ANALYZED_DB" type="{http://www.w3.org/2001/XMLSchema}double" />
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

    @XmlAttribute(name = "PEAK_DB")
    protected Double peakdb;
    @XmlAttribute(name = "PERCEIVED_DB")
    protected Double perceiveddb;
    @XmlAttribute(name = "ANALYZED_DB")
    protected Double analyzeddb;

    /**
     * Ruft den Wert der peakdb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPEAKDB() {
        return peakdb;
    }

    /**
     * Legt den Wert der peakdb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPEAKDB(Double value) {
        this.peakdb = value;
    }

    /**
     * Ruft den Wert der perceiveddb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getPERCEIVEDDB() {
        return perceiveddb;
    }

    /**
     * Legt den Wert der perceiveddb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setPERCEIVEDDB(Double value) {
        this.perceiveddb = value;
    }

    /**
     * Ruft den Wert der analyzeddb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getANALYZEDDB() {
        return analyzeddb;
    }

    /**
     * Legt den Wert der analyzeddb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setANALYZEDDB(Double value) {
        this.analyzeddb = value;
    }

}
