package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.dto.AdministratorDTO;
import com.lesBaos.drivingSchool_backend.service.AdministratorService;
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
import java.util.Collections;

public class AdministratorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AdministratorService administratorService;

    @InjectMocks
    private AdministratorController administratorController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(administratorController).build();
    }

    @Test
    public void testCreateAdministrator() throws Exception {
        AdministratorDTO administratorDTO = new AdministratorDTO(); // Assurons-nous d'initialiser cet objet avec des valeurs valides
        when(administratorService.createAdministrator(any(AdministratorDTO.class))).thenReturn(administratorDTO);

        mockMvc.perform(post("/administrators")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(administratorDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateAdministrator() throws Exception {
        Administrator administrator = new Administrator();
        administrator.setId(1L); // L'ID doit correspondre à celui qu'on met à jour
        when(administratorService.updateAdministrator(eq(1L), any(Administrator.class))).thenReturn(administrator);

        mockMvc.perform(put("/administrators/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(administrator)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAdministratorById() throws Exception {
        Administrator administrator = new Administrator();
        administrator.setId(1L);
        when(administratorService.findAdministratorById(1L)).thenReturn(administrator);

        mockMvc.perform(get("/administrators/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testFindAllAdministrators() throws Exception {
        Administrator admin1 = new Administrator();
        admin1.setId(1L);
        Administrator admin2 = new Administrator();
        admin2.setId(2L);
        when(administratorService.findAllAdministrators()).thenReturn(Arrays.asList(admin1, admin2));

        mockMvc.perform(get("/administrators"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testDeleteAdministrator() throws Exception {
        // Supposons que l'administrateur avec l'ID 1 existe
        when(administratorService.findAdministratorById(1L)).thenReturn(new Administrator());

        mockMvc.perform(delete("/administrators/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAdministratorNotFound() throws Exception {
        // Vérifie le cas où l'administrateur n'est pas trouvé
        when(administratorService.findAdministratorById(1L)).thenReturn(null);

        mockMvc.perform(delete("/administrators/1"))
                .andExpect(status().isNotFound());
    }
}