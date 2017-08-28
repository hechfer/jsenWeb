package com.mx.jsen.config;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.mx.jsen.application.client.login.LoginService;
import com.mx.jsen.application.client.login.LoginWS;
import com.mx.jsen.application.client.login.LoginWS_LoginWSImplPort_Client;
import com.mx.jsen.application.client.registrarUsuario.RegistrarUsuarioWS;

@EnableWebMvc // <mvc:annotation-driven />
@Configuration
@ComponentScan({ "com.mx.jsen.ws", "com.mx.jsen.application.controller" })
@PropertySource("classpath:config/webservice.properties")
@Import(SpringSecurityConfig.class)
public class SpringWebConfig extends WebMvcConfigurerAdapter {

	@Value("${ws.wsdl.url}")
	private String wsWsdlUrl;

	// Configuración Resources
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}
	
	// Configuración viewResolver
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//Cliente webservice login
	@Value("${ws.wsdl.url.login}")
	private String addressLogin;

	@Bean
	public LoginWS loginService() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(LoginWS.class);
		jaxWsProxyFactoryBean.setAddress(addressLogin);

		return (LoginWS) jaxWsProxyFactoryBean.create();
	}
	
	//Cliente webservice login
	@Value("${ws.wsdl.url.registrarUsuario}")
	private String addressRegistrarUsuario;
	
	@Bean
	public RegistrarUsuarioWS registrarUsuarioService() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		jaxWsProxyFactoryBean.setServiceClass(RegistrarUsuarioWS.class);
		jaxWsProxyFactoryBean.setAddress(addressRegistrarUsuario);

		return (RegistrarUsuarioWS) jaxWsProxyFactoryBean.create();
	}

}
