package com.mx.jsen.security.accessUser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mx.jsen.application.client.login.LoginWS;
import com.mx.jsen.application.vo.JLoginVO;
import com.mx.jsen.security.encryption.DataEncryption;

@Component
public class AccessUserImpl implements AccessUser{
	//logger
	private static final Logger logger = LogManager.getLogger(AccessUserImpl.class);
	
	@Autowired
	private DataEncryption encoder;
	
	@Autowired
	private LoginWS client;
	
	public JLoginVO obtenerUsuario(Long numero, String pass) throws Exception {
		
		com.mx.jsen.application.client.login.JLoginVO response = client.login(
				numero, 
				encoder.encriptarAndDesencriptar(pass, "ENC"));
		
		JLoginVO login = null;
		if(response != null){
			login = new JLoginVO();
			login.setFechaUltimaSesion(response.getFechaUltimaSesion().toGregorianCalendar().getTime());
			login.setRol(response.getRol());
			login.setNumero(response.getNumero());
			login.setId(response.getId());
			login.setEmail(encoder.encriptarAndDesencriptar(response.getCorreo(),"DES"));
		}
		return login;
	}
}
