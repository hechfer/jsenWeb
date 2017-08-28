package com.mx.jsen.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PruebaController {
	private static final Logger logger = LogManager.getLogger(PruebaController.class);

	@RequestMapping(value = { "/prueba" }, method = RequestMethod.GET)
	public ModelAndView  prueba(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response){		
		esperarXsegundos(60 * 60);
		return new ModelAndView("redirect: http://localhost:8080/JsenPortal/static/img/ciudad-noche.jpg");
	}
	
	@ResponseBody
	@RequestMapping(value = { "/prueba1" }, method = RequestMethod.GET)
	public String  prueba1(HttpSession session, HttpServletRequest request, 
			HttpServletResponse response){
		esperarXsegundos(60 * 60);
		return "http://localhost:8080/JsenPortal/static/img/ciudad-noche.jpg";
	}
	
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
