package com.mx.jsen.application.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonView;
import com.mx.jsen.application.util.Views;

public class JLoginVO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(Views.Public.class)
	private Long id;
	@JsonView(Views.Public.class)
	private Long numero;
	@JsonView(Views.Public.class)
	private String password;
	@JsonView(Views.Public.class)
	private Date fechaUltimaSesion;
	@JsonView(Views.Public.class)
	private String rol;
	@JsonView(Views.Public.class)
	private String email;
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaUltimaSesion() {
		return fechaUltimaSesion;
	}

	public void setFechaUltimaSesion(Date fechaUltimaSesion) {
		this.fechaUltimaSesion = fechaUltimaSesion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
