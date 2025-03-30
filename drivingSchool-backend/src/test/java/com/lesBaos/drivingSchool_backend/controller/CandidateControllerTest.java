package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Candidate;
import com.lesBaos.drivingSchool_backend.dto.CandidateDTO;
import com.lesBaos.drivingSchool_backend.service.CandidateService;
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

public class CandidateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CandidateService candidateService;

    @InjectMocks
    private CandidateController candidateController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(candidateController).build();
    }

    @Test
    public void testCreateCandidate() throws Exception {
        CandidateDTO candidateDTO = new CandidateDTO();
        when(candidateService.createCandidate(any(CandidateDTO.class))).thenReturn(candidateDTO);

        mockMvc.perform(post("/candidates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(candidateDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdateCandidate() throws Exception {
        Candidate candidate = new Candidate();
        candidate.setId(1L);
        when(candidateService.updateCandidate(eq(1L), any(Candidate.class))).thenReturn(candidate);

        mockMvc.perform(put("/candidates/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(candidate)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindCandidateById() throws Exception {
        Candidate candidate = new Candidate();
        candidate.setId(1L);

        when(candidateService.findCandidateById(1L)).thenReturn(candidate);

        mockMvc.perform(get("/candidates/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void testFindCandidateByIdNotFound() throws Exception {
        when(candidateService.findCandidateById(1L)).thenReturn(null);

        mockMvc.perform(get("/candidates/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllCandidates() throws Exception {
        Candidate candidate1 = new Candidate();
        candidate1.setId(1L);
        Candidate candidate2 = new Candidate();
        candidate2.setId(2L);

        when(candidateService.findAllCandidate()).thenReturn(Arrays.asList(candidate1, candidate2));

        mockMvc.perform(get("/candidates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testDeleteCandidate() throws Exception {
        // Supposons que l'administrateur avec l'ID 1 existe
        when(candidateService.findCandidateById(1L)).thenReturn(new Candidate());

        mockMvc.perform(delete("/candidates/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteCandidateNotFound() throws Exception {
        // Vérifie le cas où le candidat n'est pas trouvé
        when(candidateService.findCandidateById(1L)).thenReturn(null);

        mockMvc.perform(delete("/candidates/1"))
                .andExpect(status().isNotFound());
    }
}