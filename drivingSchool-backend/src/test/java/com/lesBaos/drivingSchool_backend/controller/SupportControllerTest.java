package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Support;
import com.lesBaos.drivingSchool_backend.dto.SupportDTO;
import com.lesBaos.drivingSchool_backend.service.SupportService;
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

public class SupportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private SupportService supportService;

    @InjectMocks
    private SupportController supportController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(supportController).build();
    }

    @Test
    public void testCreateSupport() throws Exception {
        SupportDTO supportDTO = new SupportDTO();
        when(supportService.createSupport(any(SupportDTO.class))).thenReturn(supportDTO);

        mockMvc.perform(post("/supports")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(supportDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateSupport() throws Exception {
        Support support = new Support();
        support.setId(1L);
        when(supportService.updateSupport(eq(1L), any(Support.class))).thenReturn(support);

        mockMvc.perform(put("/supports/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(support)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindSupportById() throws Exception {
        Support support = new Support();
        support.setId(1L);

        when(supportService.findSupportById(1L)).thenReturn(support);

        mockMvc.perform(get("/supports/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindSupportByIdNotFound() throws Exception {
        when(supportService.findSupportById(1L)).thenReturn(null);

        mockMvc.perform(get("/supports/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllSupports() throws Exception {
        Support support1 = new Support();
        support1.setId(1L);
        Support support2 = new Support();
        support2.setId(2L);

        when(supportService.findAllSupports()).thenReturn(Arrays.asList(support1, support2));

        mockMvc.perform(get("/supports"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 supports
    }

    @Test
    public void testDeleteSupport() throws Exception {
        // Supposons que le support avec l'ID 1 existe
        when(supportService.findSupportById(1L)).thenReturn(new Support());

        mockMvc.perform(delete("/supports/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteSupportNotFound() throws Exception {
        // Vérifie le cas où le support n'est pas trouvé
        when(supportService.findSupportById(1L)).thenReturn(null);

        mockMvc.perform(delete("/supports/1"))
                .andExpect(status().isNotFound());
    }
}