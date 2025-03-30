package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Payment;
import com.lesBaos.drivingSchool_backend.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    public PaymentDTO createPayment(PaymentDTO paymentDTO);
    public Payment updatePayment(Long id, Payment payment);
    public Payment findPaymentById(Long id);
    public void deletePayment(Long id);
    public List<Payment> findAllPayments();
}
