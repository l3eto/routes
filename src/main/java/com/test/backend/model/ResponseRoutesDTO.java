package com.test.backend.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseRoutesDTO {

	private String message;
	private HttpStatus status;
	private List<ResponseRouteDTO> routes;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<ResponseRouteDTO> getRoutes() {
		return routes;
	}
	public void setRoutes(List<ResponseRouteDTO> routes) {
		this.routes = routes;
	}
	
	
}
