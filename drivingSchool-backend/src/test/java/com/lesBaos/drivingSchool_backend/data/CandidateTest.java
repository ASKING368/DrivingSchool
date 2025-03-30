package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.enumerations.TypeCandidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CandidateTest {

    @Test
    public void testToString() {
        // Créer une instance de Candidate
        Candidate candidate = new Candidate();
        candidate.setId(1);
        candidate.setFirstName("John");
        candidate.setLastName("Doe");
        candidate.setEmail("john.doe@example.com");
        candidate.setPhone("123456789");
        candidate.setTypeCandidate(TypeCandidate.classic); // Assurez-vous que TypeCandidate est défini

        // Vérifier le contenu de toString()
        String expected = "Candidate{id=1, firstName='John', lastName='Doe', email='john.doe@example.com', phone='123456789', typeCandidate=classic}";
        assertEquals(expected, candidate.toString());
    }

    @Test
    public void testEquals() {
        Candidate candidate1 = new Candidate();
        candidate1.setId(1);

        Candidate candidate2 = new Candidate();
        candidate2.setId(1);

        Candidate candidate3 = new Candidate();
        candidate3.setId(2);

        // Vérifier l'égalité
        assertEquals(candidate1, candidate2); // Doit être égal
        assertNotEquals(candidate1, candidate3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        Candidate candidate = new Candidate();
        candidate.setId(1);

        Candidate sameCandidate = new Candidate();
        sameCandidate.setId(1);

        Candidate differentCandidate = new Candidate();
        differentCandidate.setId(2);

        // Vérifier les codes de hachage
        assertEquals(candidate.hashCode(), sameCandidate.hashCode()); // Doit être le même
        assertNotEquals(candidate.hashCode(), differentCandidate.hashCode()); // Ne doit pas être le même
    }
}