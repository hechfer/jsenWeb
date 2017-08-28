package com.mx.jsen.security.publisher;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SessionCounterListener implements HttpSessionListener {
	private static final Logger logger = LogManager.getLogger(SessionCounterListener.class);
	  private static int totalActiveSessions;

	  public static int getTotalActiveSession(){
		return totalActiveSessions;
	  }

	  @Override
	  public void sessionCreated(HttpSessionEvent arg0) {
		totalActiveSessions++;
		logger.info("sessionCreated - add one session into counter");
		System.out.println("");
	  }

	  @Override
	  public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		logger.info("sessionDestroyed - deduct one session from counter");
	  }


	}
