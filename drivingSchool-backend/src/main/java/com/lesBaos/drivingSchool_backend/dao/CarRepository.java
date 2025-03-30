package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.data.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}