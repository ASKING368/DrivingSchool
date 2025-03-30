package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Instructor;
import com.lesBaos.drivingSchool_backend.dto.InstructorDTO;

import java.util.List;

public interface InstructorService {

    public InstructorDTO createInstructor(InstructorDTO instructorDTO);
    public Instructor findInstructorById(Long id);
    public Instructor updateInstructor(Long id, Instructor instructor);
    public void deleteInstructor(Long id);
    public List<Instructor> findAllInstructors();

}
