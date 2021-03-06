package com.mx.jsen.application.client.login;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.13
 * 2017-10-28T13:13:14.648-05:00
 * Generated source version: 3.1.13
 * 
 */
@WebServiceClient(name = "loginService", 
                  wsdlLocation = "http://localhost:8080/JsenLogica/ws/loginWs?wsdl",
                  targetNamespace = "http://login.webservice.application.jsen.mx.com/") 
public class LoginService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://login.webservice.application.jsen.mx.com/", "loginService");
    public final static QName LoginWSImplPort = new QName("http://login.webservice.application.jsen.mx.com/", "LoginWSImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/JsenLogica/ws/loginWs?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(LoginService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/JsenLogica/ws/loginWs?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public LoginService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LoginService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoginService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public LoginService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public LoginService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public LoginService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns LoginWS
     */
    @WebEndpoint(name = "LoginWSImplPort")
    public LoginWS getLoginWSImplPort() {
        return super.getPort(LoginWSImplPort, LoginWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoginWS
     */
    @WebEndpoint(name = "LoginWSImplPort")
    public LoginWS getLoginWSImplPort(WebServiceFeature... features) {
        return super.getPort(LoginWSImplPort, LoginWS.class, features);
    }

}
