package com.mx.jsen.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mx.jsen.security.authProvider.CustomAuthenticationProvider;
import com.mx.jsen.security.handler.MyAuthenticationFailureHandler;
import com.mx.jsen.security.handler.MyAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan({ "com.mx.jsen.security" })
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger logger = LogManager.getLogger(SpringSecurityConfig.class);
	
	private static final String LOGIN = "/login";
    private static final String LOGIN_INVALID_SESSION_URL = "/login?reason=invalidSession";    
    private static final String ACCESS_DENIED = "/403";
    private static final String LOGOUT = "/login?reason=sessionClosed";
    
    @Autowired
    private CustomAuthenticationProvider authProvider;
    
    @Override
	protected void configure(HttpSecurity http) throws Exception {	
		
    	http.exceptionHandling().accessDeniedPage(ACCESS_DENIED);
		
    	http
	        .csrf().disable()
	        .authorizeRequests() // peticiones autorizadas
	        	.antMatchers(LOGIN+"*").permitAll()
	        	.anyRequest().authenticated()// cuando esta autenticado puede acceder a todas las url
	        .and()
	        .formLogin() // login
	        	.loginPage(LOGIN).passwordParameter("password").usernameParameter("numero") // envia user y pass al provedor de autenticación.
	        	.failureHandler(customSimpleUrlAuthenticationFailureHandler()) // cuando falla la autenticación.
	        	.successHandler(successHandler()) // cuando es exitosa la autenticación.
	        	.permitAll()
	        .and() 
	        .logout() // logout
	        	.logoutSuccessUrl(LOGOUT)
	        	.deleteCookies("JSESSIONID") //borra cookies
	        	.invalidateHttpSession(true) //termina sesion
	        	.clearAuthentication(true) // limpia valores de la autenticación
	        .and()
	        .rememberMe().key("secret").tokenValiditySeconds(86400) //falta configurar esto
	        .and()	        
	        .sessionManagement() // Sesion del usuario
	        	.sessionFixation().migrateSession()
	        	.invalidSessionUrl(LOGIN_INVALID_SESSION_URL)    	
	        	.maximumSessions(10) // diez sesiones maximas por usuario
	        	.maxSessionsPreventsLogin(true) // se activa para que no haya mas de una sesion en otro navegador
	        	.sessionRegistry( sessionRegistry())
	        ;
    	
    	http.authorizeRequests().antMatchers("/js/**").permitAll().anyRequest().authenticated();
		
		
	}
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	  web.ignoring().antMatchers("/static/**");
	  web.ignoring().antMatchers("/js/**");
	  web.ignoring().antMatchers("/registroUsuario");
	  web.ignoring().antMatchers("/registrarUsuario");
	  web.ignoring().antMatchers("/consultarLada");
	  //quitar
	  web.ignoring().antMatchers("/prueba");
	  web.ignoring().antMatchers("/prueba1");
	}
	
	@Bean
	public MyAuthenticationFailureHandler customSimpleUrlAuthenticationFailureHandler(){
        return new MyAuthenticationFailureHandler();
    }
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
        return new MyAuthenticationSuccessHandler();
    }
	
	@Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }
}
