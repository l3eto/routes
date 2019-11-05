package com.test.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.backend.model.RequestRouteDTO;
import com.test.backend.model.RequestRoutesDTO;
import com.test.backend.model.ResponseRouteDTO;
import com.test.backend.model.ResponseRoutesDTO;
import com.test.backend.model.RouteEntity;
import com.test.backend.repository.RouteRepository;

@Service
public class RouteService {

	@Autowired
	RouteRepository repository;

	public ResponseRouteDTO getAllRoutes() {
		ResponseRouteDTO response = new ResponseRouteDTO();
		try {
			List<RouteEntity> routeList = repository.findAll();
			if (routeList.size() > 0) {
				response.setMessage("Base Routes");
				response.setStatus(HttpStatus.OK);
				response.setRoutes(routeList);
				return response;
			} else {
				response.setMessage("Empty Routes");
				response.setStatus(HttpStatus.ACCEPTED);
				return response;
			}
		} catch (Exception e) {
			response.setMessage("Error in getAllRoutes : " + e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	public ResponseRouteDTO getDistance(RequestRouteDTO request) {
		try {

			return findDistance(request);

		} catch (Exception e) {
			ResponseRouteDTO response = new ResponseRouteDTO();
			response.setMessage("Error in getDistance : " + e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	public ResponseRoutesDTO getDistances(RequestRoutesDTO request) {
		ResponseRoutesDTO response = new ResponseRoutesDTO();
		try {
			List<RequestRouteDTO> routes = request.getRoutes();

			if (routes.size() > 1) {
				List<ResponseRouteDTO> distances = new ArrayList<ResponseRouteDTO>();
				for (int i = 1; i < routes.size(); i++) {
					distances.add(findDistance(routes.get(i)));
				}
				response.setMessage("ROUTES FOUND");
				response.setRoutes(distances);
				response.setStatus(HttpStatus.OK);
				return response;

			} else {
				response.setMessage("REQUIRE ROUTES");
				response.setStatus(HttpStatus.ACCEPTED);
				return response;
			}

		} catch (Exception e) {
			response.setMessage("Error in getDistances : " + e.getMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
	}

	private ResponseRouteDTO findDistance(RequestRouteDTO request) {
		ResponseRouteDTO response = new ResponseRouteDTO();
		List<String> points = request.getRoute();
		if (points.size() > 1) {
			boolean notFound = false;
			int distance = 0;
			List<RouteEntity> routes = new ArrayList<RouteEntity>();
			for (int i = 1; i < points.size(); i++) {

				RouteEntity routeEntity = repository.findByPointAAndPointB(points.get(i - 1), points.get(i));
				if (routeEntity != null) {
					routes.add(routeEntity);
					distance += routeEntity.getDistance();
				} else {
					notFound = true;
				}
			}

			if (notFound) {
				response.setMessage("NO SUCH ROUTE");
			} else {
				response.setDistance(distance);
				response.setMessage("ROUTE FOUND");
				response.setRoutes(routes);
			}
			response.setStatus(HttpStatus.OK);

		} else {
			response.setMessage("REQUIRE ROUTE");
			response.setStatus(HttpStatus.ACCEPTED);
		}
		return response;
	}

}
