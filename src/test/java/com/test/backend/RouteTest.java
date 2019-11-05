package com.test.backend;

import java.util.ArrayList;
import java.util.List;

import com.test.backend.model.RequestRouteDTO;
import com.test.backend.service.RouteService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RouteTest {

    @Autowired
    private RouteService routeService;

    @Test
    public void route1() throws Exception {
        RequestRouteDTO request = new RequestRouteDTO();
        List<String> route = new ArrayList<String>();
        route.add("A");
        route.add("B");
        route.add("C");
        request.setRoute(route);
        assertEquals(9, routeService.getDistance(request).getDistance());
        assertEquals("ROUTE FOUND", routeService.getDistance(request).getMessage());
    }

    @Test
    public void route2() throws Exception {
        RequestRouteDTO request = new RequestRouteDTO();
        List<String> route = new ArrayList<String>();
        route.add("A");
        route.add("D");
        request.setRoute(route);
        assertEquals(5, routeService.getDistance(request).getDistance());
        assertEquals("ROUTE FOUND", routeService.getDistance(request).getMessage());
    }

    @Test
    public void route3() throws Exception {
        RequestRouteDTO request = new RequestRouteDTO();
        List<String> route = new ArrayList<String>();
        route.add("A");
        route.add("D");
        route.add("C");
        request.setRoute(route);
        assertEquals(13, routeService.getDistance(request).getDistance());
        assertEquals("ROUTE FOUND", routeService.getDistance(request).getMessage());
    }

    @Test
    public void route4() throws Exception {
        RequestRouteDTO request = new RequestRouteDTO();
        List<String> route = new ArrayList<String>();
        route.add("A");
        route.add("E");
        route.add("B");
        route.add("C");
        route.add("D");
        request.setRoute(route);
        assertEquals(22, routeService.getDistance(request).getDistance());
        assertEquals("ROUTE FOUND", routeService.getDistance(request).getMessage());
    }


    @Test
    public void route5() throws Exception {
        RequestRouteDTO request = new RequestRouteDTO();
        List<String> route = new ArrayList<String>();
        route.add("A");
        route.add("E");
        route.add("D");
        request.setRoute(route);
        assertEquals(0, routeService.getDistance(request).getDistance());
        assertEquals("NO SUCH ROUTE", routeService.getDistance(request).getMessage());
    }
}