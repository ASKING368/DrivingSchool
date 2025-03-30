package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Planning;
import com.lesBaos.drivingSchool_backend.dto.PlanningDTO;
import com.lesBaos.drivingSchool_backend.service.PlanningService;
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

public class PlanningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PlanningService planningService;

    @InjectMocks
    private PlanningController planningController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(planningController).build();
    }

    @Test
    public void testCreatePlanning() throws Exception {
        PlanningDTO planningDTO = new PlanningDTO();
        when(planningService.createPlanning(any(PlanningDTO.class))).thenReturn(planningDTO);

        mockMvc.perform(post("/plannings")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(planningDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdatePlanning() throws Exception {
        Planning planning = new Planning();
        planning.setId(1L); // L'ID doit correspondre à celui que vous mettez à jour
        when(planningService.updatePlanning(eq(1L), any(Planning.class))).thenReturn(planning);

        mockMvc.perform(put("/plannings/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(planning)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindPlanningById() throws Exception {
        Planning planning = new Planning();
        planning.setId(1L);

        when(planningService.findPlanningById(1L)).thenReturn(planning);

        mockMvc.perform(get("/plannings/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindPlanningByIdNotFound() throws Exception {
        when(planningService.findPlanningById(1L)).thenReturn(null);

        mockMvc.perform(get("/plannings/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllPlannings() throws Exception {
        Planning planning1 = new Planning();
        planning1.setId(1L);
        Planning planning2 = new Planning();
        planning2.setId(2L);

        when(planningService.findAllPlannings()).thenReturn(Arrays.asList(planning1, planning2));

        mockMvc.perform(get("/plannings"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 plannings
    }

    @Test
    public void testDeletePlanning() throws Exception {
        when(planningService.findPlanningById(1L)).thenReturn(new Planning());

        mockMvc.perform(delete("/plannings/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeletePlanningNotFound() throws Exception {
        // Vérifie le cas où le planning n'est pas trouvé
        when(planningService.findPlanningById(1L)).thenReturn(null);

        mockMvc.perform(delete("/plannings/1"))
                .andExpect(status().isNotFound());
    }
}