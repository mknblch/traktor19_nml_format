//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.08.24 um 11:28:02 AM CEST 
//


package de.mknblch.nml.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}CELL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="KEYLOCK" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="FXENABLE" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="PUNCHMODE" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="ACTIVE_CELL_INDEX" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "SLOT")
public class SLOT {

    @XmlElementRef(name = "CELL", type = CELL.class, required = false)
    @XmlMixed
    protected List<Object> content;
    @XmlAttribute(name = "KEYLOCK")
    protected Byte keylock;
    @XmlAttribute(name = "FXENABLE")
    protected Byte fxenable;
    @XmlAttribute(name = "PUNCHMODE")
    protected Byte punchmode;
    @XmlAttribute(name = "ACTIVE_CELL_INDEX")
    protected Byte activecellindex;

    /**
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link CELL }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Ruft den Wert der keylock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getKEYLOCK() {
        return keylock;
    }

    /**
     * Legt den Wert der keylock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setKEYLOCK(Byte value) {
        this.keylock = value;
    }

    /**
     * Ruft den Wert der fxenable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getFXENABLE() {
        return fxenable;
    }

    /**
     * Legt den Wert der fxenable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setFXENABLE(Byte value) {
        this.fxenable = value;
    }

    /**
     * Ruft den Wert der punchmode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getPUNCHMODE() {
        return punchmode;
    }

    /**
     * Legt den Wert der punchmode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setPUNCHMODE(Byte value) {
        this.punchmode = value;
    }

    /**
     * Ruft den Wert der activecellindex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getACTIVECELLINDEX() {
        return activecellindex;
    }

    /**
     * Legt den Wert der activecellindex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setACTIVECELLINDEX(Byte value) {
        this.activecellindex = value;
    }

}
