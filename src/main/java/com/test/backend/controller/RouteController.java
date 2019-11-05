package com.test.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.backend.business.RouteBusiness;
import com.test.backend.model.RequestRouteDTO;
import com.test.backend.model.RequestRoutesDTO;
import com.test.backend.model.ResponseRouteDTO;
import com.test.backend.model.ResponseRoutesDTO;

@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	RouteBusiness routeBusiness;

	@GetMapping("/all")
	public ResponseEntity<ResponseRouteDTO> getRoutes() {
		ResponseRouteDTO response = routeBusiness.getAllRoutes();
		return new ResponseEntity<ResponseRouteDTO>(response, response.getStatus());
	}

	@PostMapping("/distance")
	public ResponseEntity<ResponseRouteDTO> distanceRoute(@RequestBody RequestRouteDTO request) {
		ResponseRouteDTO response = routeBusiness.getDistance(request);
		return new ResponseEntity<ResponseRouteDTO>(response, response.getStatus());
	}

	@PostMapping("/distances")
	public ResponseEntity<ResponseRoutesDTO> distancesRoutes(@RequestBody RequestRoutesDTO request) {
		ResponseRoutesDTO response = routeBusiness.getDistances(request);
		return new ResponseEntity<ResponseRoutesDTO>(response, response.getStatus());
	}

}
