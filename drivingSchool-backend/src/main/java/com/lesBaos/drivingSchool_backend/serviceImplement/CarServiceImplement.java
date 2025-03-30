package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.CarRepository;
import com.lesBaos.drivingSchool_backend.data.Car;
import com.lesBaos.drivingSchool_backend.dto.CarDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CarServiceImplement implements CarService {

    private final CarRepository carRepository;
    private Mappers mappers = new Mappers();

    public CarServiceImplement(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.mappers = mappers;
    }

    @Override
    public CarDTO createCar(CarDTO carDTO) {
        Car car = mappers.fromCarDTO(carDTO);
        return mappers.fromCar(carRepository.save(car));
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Car car1 = findCarById(id);
        car1.setBrand(car.getBrand());
        car1.setModel(car.getModel());
        car1.setColor(car.getColor());
        car1.setRegistration(car.getRegistration());
        car1.setStatut(car.getStatut());
        return carRepository.save(car1);
    }

    @Override
    public void deleteCar(Long id) {
        Car car = findCarById(id);
        carRepository.delete(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Car with ID %s not found", id))
         );
    }

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }
}
