package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.controller.CarController;
import com.lesBaos.drivingSchool_backend.data.Car;
import com.lesBaos.drivingSchool_backend.dto.CarDTO;
import com.lesBaos.drivingSchool_backend.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CarService carService;

    @InjectMocks
    private CarController carController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
    }

    @Test
    public void testCreateCar() throws Exception {
        CarDTO carDTO = new CarDTO();
        when(carService.createCar(any(CarDTO.class))).thenReturn(carDTO);

        mockMvc.perform(post("/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(carDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateCar() throws Exception {
        Car car = new Car();
        car.setId(1L);
        when(carService.updateCar(eq(1L), any(Car.class))).thenReturn(car);

        mockMvc.perform(put("/cars/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(car)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindCarById() throws Exception {
        Car car = new Car();
        car.setId(1L);

        when(carService.findCarById(1L)).thenReturn(car);

        mockMvc.perform(get("/cars/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindCarByIdNotFound() throws Exception {
        when(carService.findCarById(1L)).thenReturn(null);

        mockMvc.perform(get("/cars/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllCars() throws Exception {
        Car car1 = new Car();
        car1.setId(1L);
        Car car2 = new Car();
        car2.setId(2L);

        when(carService.findAllCars()).thenReturn(Arrays.asList(car1, car2));

        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 voitures
    }

    @Test
    public void testDeleteCar() throws Exception {
        // Supposons que la voiture avec l'ID 1 existe
        when(carService.findCarById(1L)).thenReturn(new Car());

        mockMvc.perform(delete("/cars/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteCarNotFound() throws Exception {
        // Vérifie le cas où la voiture n'est pas trouvée
        when(carService.findCarById(1L)).thenReturn(null);

        mockMvc.perform(delete("/cars/1"))
                .andExpect(status().isNotFound());
    }
}