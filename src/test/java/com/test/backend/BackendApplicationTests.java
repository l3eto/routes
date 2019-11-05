package com.test.backend;

import com.test.backend.service.RouteService;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BackendApplicationTests {

	@Autowired
	RouteService routeService;

	@Test
	void contextLoads() throws Exception{}

}
