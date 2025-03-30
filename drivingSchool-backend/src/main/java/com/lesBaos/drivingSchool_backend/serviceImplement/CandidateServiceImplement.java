package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.CandidateRepository;
import com.lesBaos.drivingSchool_backend.data.Candidate;
import com.lesBaos.drivingSchool_backend.dto.CandidateDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class CandidateServiceImplement implements CandidateService {

    private final CandidateRepository candidateRepository;
    private Mappers mappers = new Mappers();

    public CandidateServiceImplement(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
        this.mappers = mappers;
    }

    @Override
    public CandidateDTO createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = mappers.fromCandidateDTO(candidateDTO);
        return mappers.fromCandidate(candidateRepository.save(candidate));
    }

    @Override
    public Candidate updateCandidate(Long id, Candidate candidate) {
        Candidate candidate1 = this.findCandidateById(id);
        candidate1.setFirstName(candidate.getFirstName());
        candidate1.setLastName(candidate.getLastName());
        candidate1.setEmail(candidate.getEmail());
        candidate1.setPhone(candidate.getPhone());
        candidate1.setPassword(candidate.getPassword());
        candidate1.setTypeCandidate(candidate.getTypeCandidate());
        return candidateRepository.save(candidate1);
    }

    @Override
    public void deleteCandidate(Long id) {
        Candidate candidate = this.findCandidateById(id);
        candidateRepository.delete(candidate);
    }

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Candidate with id %s not found", id))
        );
    }

    @Override
    public List<Candidate> findAllCandidate() {
        return candidateRepository.findAll();
    }
}
