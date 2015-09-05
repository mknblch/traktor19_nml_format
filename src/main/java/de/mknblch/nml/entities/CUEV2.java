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
 *       &lt;attribute name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DISPL_ORDER" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="TYPE" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="START" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="LEN" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="REPEATS" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="HOTCUE" type="{http://www.w3.org/2001/XMLSchema}byte" />
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
    protected Byte displorder;
    @XmlAttribute(name = "TYPE")
    protected Byte type;
    @XmlAttribute(name = "START")
    protected Float start;
    @XmlAttribute(name = "LEN")
    protected Float len;
    @XmlAttribute(name = "REPEATS")
    protected Byte repeats;
    @XmlAttribute(name = "HOTCUE")
    protected Byte hotcue;

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
     *     {@link Byte }
     *     
     */
    public Byte getDISPLORDER() {
        return displorder;
    }

    /**
     * Legt den Wert der displorder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setDISPLORDER(Byte value) {
        this.displorder = value;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getTYPE() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setTYPE(Byte value) {
        this.type = value;
    }

    /**
     * Ruft den Wert der start-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSTART() {
        return start;
    }

    /**
     * Legt den Wert der start-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSTART(Float value) {
        this.start = value;
    }

    /**
     * Ruft den Wert der len-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getLEN() {
        return len;
    }

    /**
     * Legt den Wert der len-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setLEN(Float value) {
        this.len = value;
    }

    /**
     * Ruft den Wert der repeats-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getREPEATS() {
        return repeats;
    }

    /**
     * Legt den Wert der repeats-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setREPEATS(Byte value) {
        this.repeats = value;
    }

    /**
     * Ruft den Wert der hotcue-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getHOTCUE() {
        return hotcue;
    }

    /**
     * Legt den Wert der hotcue-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setHOTCUE(Byte value) {
        this.hotcue = value;
    }

}
