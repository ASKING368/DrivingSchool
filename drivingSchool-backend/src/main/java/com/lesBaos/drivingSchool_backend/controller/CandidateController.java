package com.lesBaos.drivingSchool_backend.controller;

import com.lesBaos.drivingSchool_backend.data.Candidate;
import com.lesBaos.drivingSchool_backend.dto.CandidateDTO;
import com.lesBaos.drivingSchool_backend.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates") // Meilleure pratique : grouper les endpoints
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        CandidateDTO createdCandidate = candidateService.createCandidate(candidateDTO);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        Candidate updatedCandidate = candidateService.updateCandidate(id, candidate);
        return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        if (candidateService.findCandidateById(id) != null) {
            candidateService.deleteCandidate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findCandidateById(@PathVariable Long id) {
        Candidate candidate = candidateService.findCandidateById(id);
        return candidate != null ?
                new ResponseEntity<>(candidate, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> findAllCandidates() {
        List<Candidate> candidates = candidateService.findAllCandidate();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }
}