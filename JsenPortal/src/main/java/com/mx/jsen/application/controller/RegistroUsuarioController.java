package com.mx.jsen.application.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.mx.jsen.application.client.registrarUsuario.RegistrarUsuarioWS;
import com.mx.jsen.application.util.AjaxResponseBody;
import com.mx.jsen.application.util.Constantes;
import com.mx.jsen.application.util.Views;
import com.mx.jsen.security.encryption.DataEncryption;

@Controller
public class RegistroUsuarioController {
	
	private static final Logger logger = LogManager.getLogger(RegistroUsuarioController.class);
	
	@Autowired
	private RegistrarUsuarioWS registrarUsuarioWS;
	
	@Autowired
	private DataEncryption encryption;
	
	@RequestMapping(value = { "/registroUsuario" })
	public String registroUsuario() {
		return "/registroUsuario/registroUsuario";
	}
	
	@JsonView(Views.Public.class)
	@RequestMapping(value = { "/registrarUsuario" })
	@ResponseBody
	public  AjaxResponseBody  registrarUsuario(
			@RequestParam("email") String email,
			@RequestParam("username") String username,
			@RequestParam("password") String password) {
		AjaxResponseBody response = new AjaxResponseBody();
		String mensaje = null;
		
		try {
			mensaje = registrarUsuarioWS.registrarUsuario(
					encryption.encriptarAndDesencriptar(email,"ENC"),
					encryption.encriptarAndDesencriptar(username,"ENC"),
					encryption.encriptarAndDesencriptar(password,"ENC"));
		} catch (Exception e) {
			logger.error("ERROR JSEN REGISTRAR USUARIO: "+e.getMessage());
			mensaje = "ERROR JSEN REGISTRAR USUARIO";
		}
		
		if(StringUtils.isBlank(mensaje)){
			response.setStatus(Constantes.STATUS_OK);
			response.setMessage("Te has registrado exitosamente, Bienvenido a Jsen");
		}else{
			response.setStatus(Constantes.STATUS_FAILURE);
			response.setMessage(mensaje);
		}
		
		response.setResponseBody(null);
		return response;
	}
}
