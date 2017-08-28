
package com.mx.jsen.application.client.login;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2017-08-09T16:19:31.654-05:00
 * Generated source version: 3.1.12
 * 
 */
public final class LoginWS_LoginWSImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://login.webservice.application.jsen.mx.com/", "loginService");

    private LoginWS_LoginWSImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = LoginService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        LoginService ss = new LoginService(wsdlURL, SERVICE_NAME);
        LoginWS port = ss.getLoginWSImplPort();  
        
        {
        System.out.println("Invoking login...");
        java.lang.String _login_username = "";
        java.lang.String _login_password = "";
        com.mx.jsen.application.client.login.JLoginVO _login__return = port.login(_login_username, _login_password);
        System.out.println("login.result=" + _login__return);


        }

        System.exit(0);
    }

}