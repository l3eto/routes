package com.test.backend.model;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ResponseRouteDTO {

	private String message;
	private HttpStatus status;
	private int distance;
	private List<RouteEntity> routes;

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
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
	public List<RouteEntity> getRoutes() {
		return routes;
	}
	public void setRoutes(List<RouteEntity> routes) {
		this.routes = routes;
	}
	
	
}
