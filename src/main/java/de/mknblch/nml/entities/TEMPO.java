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
 *       &lt;attribute name="BPM" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="BPM_QUALITY" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *       &lt;attribute name="BPM_TRANSIENTCOHERENCE" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "TEMPO")
public class TEMPO {

    @XmlAttribute(name = "BPM")
    protected Float bpm;
    @XmlAttribute(name = "BPM_QUALITY")
    protected Byte bpmquality;
    @XmlAttribute(name = "BPM_TRANSIENTCOHERENCE")
    protected Float bpmtransientcoherence;

    /**
     * Ruft den Wert der bpm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBPM() {
        return bpm;
    }

    /**
     * Legt den Wert der bpm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBPM(Float value) {
        this.bpm = value;
    }

    /**
     * Ruft den Wert der bpmquality-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getBPMQUALITY() {
        return bpmquality;
    }

    /**
     * Legt den Wert der bpmquality-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setBPMQUALITY(Byte value) {
        this.bpmquality = value;
    }

    /**
     * Ruft den Wert der bpmtransientcoherence-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getBPMTRANSIENTCOHERENCE() {
        return bpmtransientcoherence;
    }

    /**
     * Legt den Wert der bpmtransientcoherence-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setBPMTRANSIENTCOHERENCE(Float value) {
        this.bpmtransientcoherence = value;
    }

}
