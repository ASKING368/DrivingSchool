package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.enumerations.TypeCandidate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdministratorTest {

    @Test
    public void testToString() {
        // Créer une instance de Candidate
        Administrator administrator = new Administrator();
        administrator.setId(1);
        administrator.setFirstName("John");
        administrator.setLastName("Doe");
        administrator.setEmail("john.doe@xyz.com");
        administrator.setPassword("password635");
        administrator.setPhone("123456789");

        // Vérifier le contenu de toString()
        String expected = "Administrator{id=1, firstName='John', lastName='Doe', email='john.doe@xyz.com', password='password635', phone='123456789'}";
        assertEquals(expected, administrator.toString());
    }

    @Test
    public void testEquals() {
        Administrator administrator1 = new Administrator();
        administrator1.setId(1);

        Administrator administrator2 = new Administrator();
        administrator2.setId(1);

        Administrator administrator3 = new Administrator();
        administrator3.setId(2);

        // Vérifier l'égalité
        assertEquals(administrator1, administrator2); // Doit être égal
        assertNotEquals(administrator1, administrator3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        Administrator administrator = new Administrator();
        administrator.setId(1);

        Administrator sameAdministrator = new Administrator();
        sameAdministrator.setId(1);

        Administrator differentAdministrator = new Administrator();
        differentAdministrator.setId(2);

        // Vérifier les codes de hachage
        assertEquals(administrator.hashCode(), sameAdministrator.hashCode()); // Doit être le même
        assertNotEquals(administrator.hashCode(), differentAdministrator.hashCode()); // Ne doit pas être le même
    }
}