package com.mx.jsen.security.authProvider;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.mx.jsen.application.vo.JLoginVO;
import com.mx.jsen.security.accessUser.AccessUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	public CustomAuthenticationProvider() {
	    logger.info("*** CustomAuthenticationProvider created ***");
	}
	//Logger
	private static final Logger logger = LogManager.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private AccessUser accessUser;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        try {
        	JLoginVO login = accessUser.obtenerUsuario(Long.valueOf(name), password);
			if(login != null){
				List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
			    grantedAuths.add(new SimpleGrantedAuthority(login.getRol()));
			    
				return new UsernamePasswordAuthenticationToken(name, password, grantedAuths);	
			}else{
				logger.info("Login fail!");
				return null;
			}
		} catch (Exception e) {
			logger.info("Authentication Error");
			return null;
		}        
	}
 
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
 
}
