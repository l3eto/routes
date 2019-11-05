package com.test.backend.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.backend.model.RequestRouteDTO;
import com.test.backend.model.RequestRoutesDTO;
import com.test.backend.model.ResponseRouteDTO;
import com.test.backend.model.ResponseRoutesDTO;
import com.test.backend.service.RouteService;

@Component
public class RouteBusiness {

	@Autowired
	RouteService routeService;

	public ResponseRouteDTO getDistance(RequestRouteDTO request) {
		return routeService.getDistance(request);
	}

	public ResponseRoutesDTO getDistances(RequestRoutesDTO request) {
		return routeService.getDistances(request);
	}

	public ResponseRouteDTO getAllRoutes() {
		return routeService.getAllRoutes();
	}

	
	
}
