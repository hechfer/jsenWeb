package com.mx.jsen.security.publisher;

import javax.servlet.http.HttpSessionEvent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.web.session.HttpSessionEventPublisher;

public class CustomHttpSessionEventPublisher extends HttpSessionEventPublisher {
	private static final Logger logger = LogManager.getLogger(CustomHttpSessionEventPublisher.class);
	private static Integer sessionTimeout = 60*60; // 1 hora

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.info("SESION CREADA *** ");
		event.getSession().setMaxInactiveInterval(sessionTimeout);
		super.sessionCreated(event);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("TERMINO SESION *** ");
		super.sessionDestroyed(event);
	}

}
