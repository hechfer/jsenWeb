package com.mx.jsen.application.util;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {
	@JsonView(Views.Public.class)
	private Object responseBody;
	@JsonView(Views.Public.class)
	private String message;
	@JsonView(Views.Public.class)
	private int responseCode;
	@JsonView(Views.Public.class)
	private String status;
	public AjaxResponseBody() {
	    responseCode = 200; //default HTTP 200 OK
	}
	public Object getResponseBody() {
	    return responseBody;
	}

	public void setResponseBody(Object responseBody) {
	    this.responseBody = responseBody;
	}

	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

	public int getResponseCode() {
	    return responseCode;
	}

	public void setResponseCode(int responseCode) {
	    this.responseCode = responseCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
