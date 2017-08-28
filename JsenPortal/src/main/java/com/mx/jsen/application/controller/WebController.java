package com.mx.jsen.application.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	private static final Logger logger = LogManager.getLogger(WebController.class);

	@RequestMapping(value = { "/", "home" })
	public String home() {
		return "/login/home";
	}

	@RequestMapping(value = { "/login" })
	public String login() {
		return "/login/login";
	}
}
