package com.mx.jsen.config;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.mx.jsen.security.publisher.CustomHttpSessionEventPublisher;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	// Logger
	private static final Logger logger = LogManager.getLogger(WebInitializer.class);

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void registerDispatcherServlet(ServletContext servletContext) {
		super.registerDispatcherServlet(servletContext);
		servletContext.addListener(new CustomHttpSessionEventPublisher());
	}
}
