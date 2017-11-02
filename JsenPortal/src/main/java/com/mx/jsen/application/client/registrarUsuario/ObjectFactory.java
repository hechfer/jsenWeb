
package com.mx.jsen.application.client.registrarUsuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mx.jsen.application.client.registrarUsuario package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarLada_QNAME = new QName("http://registrarusuario.webservice.application.jsen.mx.com/", "consultarLada");
    private final static QName _ConsultarLadaResponse_QNAME = new QName("http://registrarusuario.webservice.application.jsen.mx.com/", "consultarLadaResponse");
    private final static QName _RegistrarUsuario_QNAME = new QName("http://registrarusuario.webservice.application.jsen.mx.com/", "registrarUsuario");
    private final static QName _RegistrarUsuarioResponse_QNAME = new QName("http://registrarusuario.webservice.application.jsen.mx.com/", "registrarUsuarioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mx.jsen.application.client.registrarUsuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarLada }
     * 
     */
    public ConsultarLada createConsultarLada() {
        return new ConsultarLada();
    }

    /**
     * Create an instance of {@link ConsultarLadaResponse }
     * 
     */
    public ConsultarLadaResponse createConsultarLadaResponse() {
        return new ConsultarLadaResponse();
    }

    /**
     * Create an instance of {@link RegistrarUsuario }
     * 
     */
    public RegistrarUsuario createRegistrarUsuario() {
        return new RegistrarUsuario();
    }

    /**
     * Create an instance of {@link RegistrarUsuarioResponse }
     * 
     */
    public RegistrarUsuarioResponse createRegistrarUsuarioResponse() {
        return new RegistrarUsuarioResponse();
    }

    /**
     * Create an instance of {@link TblLada }
     * 
     */
    public TblLada createTblLada() {
        return new TblLada();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarLada }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registrarusuario.webservice.application.jsen.mx.com/", name = "consultarLada")
    public JAXBElement<ConsultarLada> createConsultarLada(ConsultarLada value) {
        return new JAXBElement<ConsultarLada>(_ConsultarLada_QNAME, ConsultarLada.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarLadaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registrarusuario.webservice.application.jsen.mx.com/", name = "consultarLadaResponse")
    public JAXBElement<ConsultarLadaResponse> createConsultarLadaResponse(ConsultarLadaResponse value) {
        return new JAXBElement<ConsultarLadaResponse>(_ConsultarLadaResponse_QNAME, ConsultarLadaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registrarusuario.webservice.application.jsen.mx.com/", name = "registrarUsuario")
    public JAXBElement<RegistrarUsuario> createRegistrarUsuario(RegistrarUsuario value) {
        return new JAXBElement<RegistrarUsuario>(_RegistrarUsuario_QNAME, RegistrarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://registrarusuario.webservice.application.jsen.mx.com/", name = "registrarUsuarioResponse")
    public JAXBElement<RegistrarUsuarioResponse> createRegistrarUsuarioResponse(RegistrarUsuarioResponse value) {
        return new JAXBElement<RegistrarUsuarioResponse>(_RegistrarUsuarioResponse_QNAME, RegistrarUsuarioResponse.class, null, value);
    }

}
