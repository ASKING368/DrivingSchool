package com.lesBaos.drivingSchool_backend.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesBaos.drivingSchool_backend.data.Payment;
import com.lesBaos.drivingSchool_backend.dto.PaymentDTO;
import com.lesBaos.drivingSchool_backend.service.PaymentService;
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

public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(paymentController).build();
    }

    @Test
    public void testCreatePayment() throws Exception {
        PaymentDTO paymentDTO = new PaymentDTO();
        when(paymentService.createPayment(any(PaymentDTO.class))).thenReturn(paymentDTO);

        mockMvc.perform(post("/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(paymentDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdatePayment() throws Exception {
        Payment payment = new Payment();
        payment.setId(1L);
        when(paymentService.updatePayment(eq(1L), any(Payment.class))).thenReturn(payment);

        mockMvc.perform(put("/payments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(payment)))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindPaymentById() throws Exception {
        Payment payment = new Payment();
        payment.setId(1L);

        when(paymentService.findPaymentById(1L)).thenReturn(payment);

        mockMvc.perform(get("/payments/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1)); // Vérifie que l'ID retourné est correct
    }

    @Test
    public void testFindPaymentByIdNotFound() throws Exception {
        when(paymentService.findPaymentById(1L)).thenReturn(null);

        mockMvc.perform(get("/payments/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeletePayment() throws Exception {
        // Supposons que le paiement avec l'ID 1 existe
        when(paymentService.findPaymentById(1L)).thenReturn(new Payment());

        mockMvc.perform(delete("/payments/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeletePaymentNotFound() throws Exception {
        // Vérifie le cas où le paiement n'est pas trouvé
        when(paymentService.findPaymentById(1L)).thenReturn(null);

        mockMvc.perform(delete("/payments/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllPayments() throws Exception {
        Payment payment1 = new Payment();
        payment1.setId(1L);
        Payment payment2 = new Payment();
        payment2.setId(2L);

        when(paymentService.findAllPayments()).thenReturn(Arrays.asList(payment1, payment2));

        mockMvc.perform(get("/payments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2))); // Vérifie que la liste contient 2 paiements
    }
}