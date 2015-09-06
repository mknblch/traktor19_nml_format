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
 *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DISPL_ORDER" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="TYPE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="START" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="LEN" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="REPEATS" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="HOTCUE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "CUE_V2")
public class CUEV2 {

    @XmlAttribute(name = "NAME")
    protected String name;
    @XmlAttribute(name = "DISPL_ORDER")
    protected Integer displorder;
    @XmlAttribute(name = "TYPE")
    protected Integer type;
    @XmlAttribute(name = "START")
    protected Double start;
    @XmlAttribute(name = "LEN")
    protected Integer len;
    @XmlAttribute(name = "REPEATS")
    protected Integer repeats;
    @XmlAttribute(name = "HOTCUE")
    protected Integer hotcue;

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

    /**
     * Ruft den Wert der displorder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDISPLORDER() {
        return displorder;
    }

    /**
     * Legt den Wert der displorder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDISPLORDER(Integer value) {
        this.displorder = value;
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
     * Ruft den Wert der start-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getSTART() {
        return start;
    }

    /**
     * Legt den Wert der start-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setSTART(Double value) {
        this.start = value;
    }

    /**
     * Ruft den Wert der len-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLEN() {
        return len;
    }

    /**
     * Legt den Wert der len-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLEN(Integer value) {
        this.len = value;
    }

    /**
     * Ruft den Wert der repeats-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getREPEATS() {
        return repeats;
    }

    /**
     * Legt den Wert der repeats-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setREPEATS(Integer value) {
        this.repeats = value;
    }

    /**
     * Ruft den Wert der hotcue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHOTCUE() {
        return hotcue;
    }

    /**
     * Legt den Wert der hotcue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHOTCUE(Integer value) {
        this.hotcue = value;
    }

}
