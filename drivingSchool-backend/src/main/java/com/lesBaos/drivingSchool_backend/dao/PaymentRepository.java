package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.data.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
