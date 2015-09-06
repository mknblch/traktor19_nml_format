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
 *         &lt;element ref="{}CELL" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="KEYLOCK" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="FXENABLE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="PUNCHMODE" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ACTIVE_CELL_INDEX" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cell"
})
@XmlRootElement(name = "SLOT")
public class SLOT {

    @XmlElement(name = "CELL")
    protected List<CELL> cell;
    @XmlAttribute(name = "KEYLOCK")
    protected Integer keylock;
    @XmlAttribute(name = "FXENABLE")
    protected Integer fxenable;
    @XmlAttribute(name = "PUNCHMODE")
    protected Integer punchmode;
    @XmlAttribute(name = "ACTIVE_CELL_INDEX")
    protected Integer activecellindex;

    /**
     * Gets the value of the cell property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cell property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCELL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CELL }
     * 
     * 
     */
    public List<CELL> getCELL() {
        if (cell == null) {
            cell = new ArrayList<CELL>();
        }
        return this.cell;
    }

    /**
     * Ruft den Wert der keylock-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKEYLOCK() {
        return keylock;
    }

    /**
     * Legt den Wert der keylock-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKEYLOCK(Integer value) {
        this.keylock = value;
    }

    /**
     * Ruft den Wert der fxenable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFXENABLE() {
        return fxenable;
    }

    /**
     * Legt den Wert der fxenable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFXENABLE(Integer value) {
        this.fxenable = value;
    }

    /**
     * Ruft den Wert der punchmode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPUNCHMODE() {
        return punchmode;
    }

    /**
     * Legt den Wert der punchmode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPUNCHMODE(Integer value) {
        this.punchmode = value;
    }

    /**
     * Ruft den Wert der activecellindex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getACTIVECELLINDEX() {
        return activecellindex;
    }

    /**
     * Legt den Wert der activecellindex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setACTIVECELLINDEX(Integer value) {
        this.activecellindex = value;
    }

}
