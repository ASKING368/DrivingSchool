package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.InstructorRepository;
import com.lesBaos.drivingSchool_backend.data.Instructor;
import com.lesBaos.drivingSchool_backend.dto.InstructorDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional

public class InstructorServiceImplement implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final Mappers mappers;

    public InstructorServiceImplement(InstructorRepository instructorRepository, Mappers mappers) {
        this.instructorRepository = instructorRepository;
        this.mappers = mappers;
    }

    @Override
    public InstructorDTO createInstructor(InstructorDTO instructorDTO) {
        Instructor instructor = mappers.fromInstructorDTO(instructorDTO);
        return mappers.fromInstructor(instructorRepository.save(instructor));
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Instructor with id %s not found", id))
        );
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor instructor) {
        Instructor instructor1 = findInstructorById(id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhone(instructor.getPhone());
        instructor1.setPassword(instructor.getPassword());
        return instructorRepository.save(instructor1);
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = findInstructorById(id);
        instructorRepository.delete(instructor);
    }

    @Override
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }
}
