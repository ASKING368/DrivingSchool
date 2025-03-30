package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Instructor;
import com.lesBaos.drivingSchool_backend.dto.InstructorDTO;
import com.lesBaos.drivingSchool_backend.service.InstructorService;
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

public class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private InstructorService instructorService;

    @InjectMocks
    private InstructorController instructorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(instructorController).build();
    }

    @Test
    public void testCreateInstructor() throws Exception {
        InstructorDTO instructorDTO = new InstructorDTO(); // Initialisation des propriétés nécessaires
        when(instructorService.createInstructor(any(InstructorDTO.class))).thenReturn(instructorDTO);

        mockMvc.perform(post("/instructors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(instructorDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindInstructorById() throws Exception {
        Instructor instructor = new Instructor();
        instructor.setId(1L);

        when(instructorService.findInstructorById(1L)).thenReturn(instructor);

        mockMvc.perform(get("/instructors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindInstructorByIdNotFound() throws Exception {
        when(instructorService.findInstructorById(1L)).thenReturn(null);

        mockMvc.perform(get("/instructors/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateInstructor() throws Exception {
        Instructor instructor = new Instructor();
        instructor.setId(1L);
        when(instructorService.updateInstructor(eq(1L), any(Instructor.class))).thenReturn(instructor);

        mockMvc.perform(put("/instructors/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(instructor)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteInstructor() throws Exception {
        // Supposons que l'instructeur avec l'ID 1 existe
        when(instructorService.findInstructorById(1L)).thenReturn(new Instructor());

        mockMvc.perform(delete("/instructors/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteInstructorNotFound() throws Exception {
        // Vérifie le cas où l'instructeur n'est pas trouvé
        when(instructorService.findInstructorById(1L)).thenReturn(null);

        mockMvc.perform(delete("/instructors/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllInstructors() throws Exception {
        Instructor instructor1 = new Instructor();
        instructor1.setId(1L);
        Instructor instructor2 = new Instructor();
        instructor2.setId(2L);

        when(instructorService.findAllInstructors()).thenReturn(Arrays.asList(instructor1, instructor2));

        mockMvc.perform(get("/instructors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 instructeurs
    }
}