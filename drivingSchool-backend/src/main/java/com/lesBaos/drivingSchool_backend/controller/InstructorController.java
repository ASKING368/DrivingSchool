package com.lesBaos.drivingSchool_backend.controller;

import com.lesBaos.drivingSchool_backend.data.Instructor;
import com.lesBaos.drivingSchool_backend.dto.InstructorDTO;
import com.lesBaos.drivingSchool_backend.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors") // Regroupe tous les endpoints sous une même route
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<InstructorDTO> createInstructor(@RequestBody InstructorDTO instructorDTO) {
        InstructorDTO createdInstructor = instructorService.createInstructor(instructorDTO);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.findInstructorById(id);
        return instructor != null ?
                new ResponseEntity<>(instructor, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);
        return new ResponseEntity<>(updatedInstructor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        if (instructorService.findInstructorById(id) != null) {
            instructorService.deleteInstructor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> findAllInstructors() {
        List<Instructor> instructors = instructorService.findAllInstructors();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }
}