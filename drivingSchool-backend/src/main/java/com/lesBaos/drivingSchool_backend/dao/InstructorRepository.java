package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.data.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
