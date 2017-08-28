package com.mx.jsen.application.client.login;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-09T16:19:31.711-05:00
 * Generated source version: 3.1.12
 * 
 */
@WebService(targetNamespace = "http://login.webservice.application.jsen.mx.com/", name = "LoginWS")
@XmlSeeAlso({ObjectFactory.class})
public interface LoginWS {

    @WebMethod
    @RequestWrapper(localName = "login", targetNamespace = "http://login.webservice.application.jsen.mx.com/", className = "com.mx.jsen.application.client.login.Login")
    @ResponseWrapper(localName = "loginResponse", targetNamespace = "http://login.webservice.application.jsen.mx.com/", className = "com.mx.jsen.application.client.login.LoginResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.mx.jsen.application.client.login.JLoginVO login(
        @WebParam(name = "username", targetNamespace = "")
        java.lang.String username,
        @WebParam(name = "password", targetNamespace = "")
        java.lang.String password
    );
}