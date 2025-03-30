package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.Instructor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InstructorTest {

    @Test
    public void testToString() {
        // Créer une instance de Instructor
        Instructor instructor = new Instructor(1, "John", "Doe",
                "john.doe@example.com", "password123",
                "1234567890", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        // Vérifier le résultat de toString()
        String expected = "Instructor{id=1, firstName='John', lastName='Doe', email='john.doe@example.com', phone='1234567890', cars=0 cars, plannings=0 plannings, courses=0 courses, supports=0 supports}";

        assertEquals(expected, instructor.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux instances de Instructor ayant le même ID
        Instructor instructor1 = new Instructor(1, "John", "Doe",
                "john.doe@example.com", "password123",
                "1234567890", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        Instructor instructor2 = new Instructor(1, "John", "Doe",
                "john.doe@example.com", "password123",
                "1234567890", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        Instructor instructor3 = new Instructor(2, "Jane", "Smith",
                "jane.smith@example.com", "password456",
                "0987654321", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        // Vérifier l'égalité
        assertEquals(instructor1, instructor2); // Doit être égal
        assertNotEquals(instructor1, instructor3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des instances de Instructor
        Instructor instructor1 = new Instructor(1, "John", "Doe",
                "john.doe@example.com", "password123",
                "1234567890", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        Instructor instructor2 = new Instructor(1, "John", "Doe",
                "john.doe@example.com", "password123",
                "1234567890", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        Instructor instructor3 = new Instructor(2, "Jane", "Smith",
                "jane.smith@example.com", "password456",
                "0987654321", new ArrayList<>(),
                new ArrayList<>(), new ArrayList<>(),
                new ArrayList<>());

        // Vérifier les codes de hachage
        assertEquals(instructor1.hashCode(), instructor2.hashCode()); // Doit être le même
        assertNotEquals(instructor1.hashCode(), instructor3.hashCode()); // Ne doit pas être le même
    }
}