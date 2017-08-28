package com.mx.jsen.security.handler;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class MyAuthenticationFailureHandler  extends SimpleUrlAuthenticationFailureHandler{
	/*@Autowired
	private SessionRegistry sessionRegistries;*/
	
	private static final String ERROR = "/login?error=auth";
	private static final String ERROR_1 = "/login?error=1";
	private static final String ERROR_2 = "/login?error=2";
	private static final String ERROR_3 = "/login?reason=sessionExpired";
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		setDefaultFailureUrl(ERROR);// error al autenticarte

		if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			setDefaultFailureUrl(ERROR_1);
		} else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
			setDefaultFailureUrl(ERROR_2);
		} else if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
			// Remueve la informacion de las sesiones activas.
			/*for (Object principal : sessionRegistries.getAllPrincipals()) {
				if(principal.toString().equals(request.getParameter("username"))){
					for (SessionInformation information : sessionRegistries.getAllSessions(principal, true)) {						
						sessionRegistries.removeSessionInformation(information.getSessionId());
					}
				}
	            
	        }*/
			setDefaultFailureUrl(ERROR_3); // inicio de sesion multiple en otro navegador
		}

		super.onAuthenticationFailure(request, response, exception);
	}
}
