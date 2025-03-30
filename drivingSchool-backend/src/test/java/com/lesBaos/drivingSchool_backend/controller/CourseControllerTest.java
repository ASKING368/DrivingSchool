package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Course;
import com.lesBaos.drivingSchool_backend.dto.CourseDTO;
import com.lesBaos.drivingSchool_backend.service.CourseService;
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

public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CourseService courseService;

    @InjectMocks
    private CourseController courseController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    public void testCreateCourse() throws Exception {
        CourseDTO courseDTO = new CourseDTO(); // Assurez-vous d'initialiser cet objet avec les propriétés nécessaires
        when(courseService.createCourse(any(CourseDTO.class))).thenReturn(courseDTO);

        mockMvc.perform(post("/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(courseDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateCourse() throws Exception {
        Course course = new Course();
        course.setId(1L);
        when(courseService.updateCourse(eq(1L), any(Course.class))).thenReturn(course);

        mockMvc.perform(put("/courses/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(course)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindCourseById() throws Exception {
        Course course = new Course();
        course.setId(1L);

        when(courseService.findCourseById(1L)).thenReturn(course);

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindCourseByIdNotFound() throws Exception {
        when(courseService.findCourseById(1L)).thenReturn(null);

        mockMvc.perform(get("/courses/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllCourses() throws Exception {
        Course course1 = new Course();
        course1.setId(1L);
        Course course2 = new Course();
        course2.setId(2L);

        when(courseService.findAllCourses()).thenReturn(Arrays.asList(course1, course2));

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 cours
    }

    @Test
    public void testDeleteCourse() throws Exception {
        // Supposons que le cours avec l'ID 1 existe
        when(courseService.findCourseById(1L)).thenReturn(new Course());

        mockMvc.perform(delete("/courses/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteCourseNotFound() throws Exception {
        // Vérifie le cas où le cours n'est pas trouvé
        when(courseService.findCourseById(1L)).thenReturn(null);

        mockMvc.perform(delete("/courses/1"))
                .andExpect(status().isNotFound());
    }
}