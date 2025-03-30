package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.dao.CandidateRepository;
import com.lesBaos.drivingSchool_backend.data.Candidate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CandidateRepositoryTest {

    @Autowired
    private CandidateRepository candidateRepository;

    private Candidate testCandidate;

    @BeforeEach
    public void setUp() {
        testCandidate = new Candidate();
        testCandidate.setFirstName("Alice Smith");
        testCandidate.setEmail("alice.smith@example.com");
    }

    @Test
    @Rollback(false) // Le rollback est désactivé pour conserver les données insérées
    public void testCreateCandidate() {
        Candidate savedCandidate = candidateRepository.save(testCandidate);
        assertThat(savedCandidate).isNotNull();
        assertThat(savedCandidate.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindCandidateById() {
        Candidate savedCandidate = candidateRepository.save(testCandidate);
        Optional<Candidate> foundCandidate = candidateRepository.findById(savedCandidate.getId());
        assertThat(foundCandidate).isPresent();
        assertThat(foundCandidate.get().getFirstName()).isEqualTo(testCandidate.getFirstName());
    }

    @Test
    public void testUpdateCandidate() {
        Candidate savedCandidate = candidateRepository.save(testCandidate);
        savedCandidate.setFirstName("Bob");
        Candidate updatedCandidate = candidateRepository.save(savedCandidate);

        assertThat(updatedCandidate.getFirstName()).isEqualTo("Bob");
    }

    @Test
    public void testDeleteCandidate() {
        Candidate savedCandidate = candidateRepository.save(testCandidate);
        Long candidateId = savedCandidate.getId();
        candidateRepository.deleteById(candidateId);

        Optional<Candidate> deletedCandidate = candidateRepository.findById(candidateId);
        assertThat(deletedCandidate).isNotPresent();
    }
}