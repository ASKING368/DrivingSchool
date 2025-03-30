package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Candidate;
import com.lesBaos.drivingSchool_backend.dto.CandidateDTO;

import java.util.List;

public interface CandidateService {

    public CandidateDTO createCandidate(CandidateDTO candidateDTO);
    public Candidate updateCandidate(Long id, Candidate candidate);
    public void deleteCandidate(Long id);
    public Candidate findCandidateById(Long id);
    public List<Candidate> findAllCandidate();
}
