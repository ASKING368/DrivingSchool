package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.dao.CarRepository;
import com.lesBaos.drivingSchool_backend.data.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    private Car testCar;

    @BeforeEach
    public void setUp() {
        testCar = new Car();
        testCar.setBrand("Toyota");
        testCar.setModel("Camry");
        testCar.setColor("Red");
    }

    @Test
    @Rollback(false) // Le rollback est désactivé pour conserver les données insérées
    public void testCreateCar() {
        Car savedCar = carRepository.save(testCar);
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindCarById() {
        Car savedCar = carRepository.save(testCar);
        Optional<Car> foundCar = carRepository.findById(savedCar.getId());
        assertThat(foundCar).isPresent();
        assertThat(foundCar.get().getBrand()).isEqualTo(testCar.getBrand());
    }

    @Test
    public void testUpdateCar() {
        Car savedCar = carRepository.save(testCar);
        savedCar.setModel("Corolla");
        Car updatedCar = carRepository.save(savedCar);

        assertThat(updatedCar.getModel()).isEqualTo("Corolla");
    }

    @Test
    public void testDeleteCar() {
        Car savedCar = carRepository.save(testCar);
        Long carId = savedCar.getId();
        carRepository.deleteById(carId);

        Optional<Car> deletedCar = carRepository.findById(carId);
        assertThat(deletedCar).isNotPresent();
    }
}