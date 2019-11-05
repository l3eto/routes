package com.test.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.backend.model.RouteEntity;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {

	@Query("SELECT T FROM RouteEntity T WHERE T.pointA = :pointA AND T.pointB = :pointB")
	RouteEntity findByPointAAndPointB(String pointA, String pointB);

}