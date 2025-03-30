package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.data.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
