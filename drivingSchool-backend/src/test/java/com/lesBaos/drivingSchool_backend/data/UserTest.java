package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testToString() {
        // Créer une instance de User
        User user = new User(1, "user@xyz.com", "securePassword");

        // Vérifier le résultat de toString()
        String expected = "User{id=1, email='user@xyz.com'}";

        // Vérifier que le résultat de toString() est conforme aux attentes
        assertEquals(expected, user.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux utilisateurs avec le même ID
        User user1 = new User(1, "user1@xyz.com", "password1");
        User user2 = new User(1, "user2@xyz.com", "password2");
        User user3 = new User(2, "user3@xyz.com", "password3");

        // Vérifier que user1 et user2 sont égaux (même ID)
        assertEquals(user1, user2); // Doit être égal
        // Vérifier que user1 et user3 ne sont pas égaux (ID différent)
        assertNotEquals(user1, user3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des utilisateurs
        User user1 = new User(1, "user1@xyz.com", "password1");
        User user2 = new User(1, "user2@xyz.com", "password2");
        User user3 = new User(2, "user3@xyz.com", "password3");

        // Vérifier que les hashcodes de user1 et user2 sont identiques à cause du même ID
        assertEquals(user1.hashCode(), user2.hashCode()); // Doit être le même
        // Vérifier que le hashcode de user1 est différent de user3
        assertNotEquals(user1.hashCode(), user3.hashCode()); // Ne doit pas être le même
    }
}