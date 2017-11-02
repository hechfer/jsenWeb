
package com.mx.jsen.application.client.registrarUsuario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonView;
import com.mx.jsen.application.util.Views;


/**
 * <p>Clase Java para tblLada complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tblLada"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="claveLocalidad" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idLada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="localidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="pais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tblLada", propOrder = {
    "claveLocalidad",
    "idLada",
    "localidad",
    "pais"
})
public class TblLada {
	@JsonView(Views.Public.class)
    protected Long claveLocalidad;
	@JsonView(Views.Public.class)
    protected Long idLada;
	@JsonView(Views.Public.class)
    protected String localidad;
	@JsonView(Views.Public.class)
    protected String pais;

    /**
     * Obtiene el valor de la propiedad claveLocalidad.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClaveLocalidad() {
        return claveLocalidad;
    }

    /**
     * Define el valor de la propiedad claveLocalidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClaveLocalidad(Long value) {
        this.claveLocalidad = value;
    }

    /**
     * Obtiene el valor de la propiedad idLada.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdLada() {
        return idLada;
    }

    /**
     * Define el valor de la propiedad idLada.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdLada(Long value) {
        this.idLada = value;
    }

    /**
     * Obtiene el valor de la propiedad localidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Define el valor de la propiedad localidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidad(String value) {
        this.localidad = value;
    }

    /**
     * Obtiene el valor de la propiedad pais.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define el valor de la propiedad pais.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPais(String value) {
        this.pais = value;
    }

}
