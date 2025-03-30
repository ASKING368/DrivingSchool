package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Car;
import com.lesBaos.drivingSchool_backend.dto.CarDTO;

import java.util.List;

public interface CarService {

    public CarDTO createCar(CarDTO carDTO);
    public Car updateCar(Long id, Car car);
    public void deleteCar(Long id);
    public Car findCarById(Long id);
    public List<Car> findAllCars();
}
