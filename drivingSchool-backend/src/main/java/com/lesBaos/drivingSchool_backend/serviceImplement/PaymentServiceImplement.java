package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.PaymentRepository;
import com.lesBaos.drivingSchool_backend.data.Payment;
import com.lesBaos.drivingSchool_backend.dto.PaymentDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImplement implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final Mappers mappers;

    public PaymentServiceImplement(PaymentRepository paymentRepository, Mappers mappers) {
        this.paymentRepository = paymentRepository;
        this.mappers = mappers;
    }

    @Override
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
        Payment payment = mappers.fromPaymentDTO(paymentDTO);
        return mappers.fromPayment(paymentRepository.save(payment));
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment payment1 = findPaymentById(id);
        payment1.setAmount(payment.getAmount());
        payment1.setDate(payment.getDate());
        payment1.setReference(payment.getReference());
        return paymentRepository.save(payment1);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Payment with id %s not found", id))
        );
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = findPaymentById(id);
        paymentRepository.delete(payment);
    }

    @Override
    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }
}
