package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.Course;
import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.enumerations.TypeCourse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    @Test
    public void testToString() {
        // Créer une instance de Course
        Course course = new Course(1, "Course Name", "Instructor Name", new Date(),
                "Location", TypeCourse.THEORY, null,
                new ArrayList<>(), new ArrayList<>(), null);

        // Vérifier le résultat attendu de toString()
        String expected = "Course{id=1, name='Course Name', instructorName='Instructor Name', date="
                + course.getDate() + ", location='Location', typeCourse=THEORY, administrator=null}";

        assertEquals(expected, course.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux instances de Course ayant le même ID
        Course course1 = new Course(1, "Course Name", "Instructor Name", new Date(),
                "Location", TypeCourse.THEORY, null,
                new ArrayList<>(), new ArrayList<>(), null);

        Course course2 = new Course(1, "Course Name", "Instructor Name", new Date(),
                "Location", TypeCourse.THEORY, null,
                new ArrayList<>(), new ArrayList<>(), null);

        Course course3 = new Course(2, "Another Course", "Another Instructor", new Date(),
                "Another Location", TypeCourse.PRACTICE, null,
                new ArrayList<>(), new ArrayList<>(), null);

        // vérifier l'égalité
        assertEquals(course1, course2); // Doit être égal
        assertNotEquals(course1, course3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des instances de Course
        Course course1 = new Course(1, "Course Name", "Instructor Name", new Date(),
                "Location", TypeCourse.THEORY, null,
                new ArrayList<>(), new ArrayList<>(), null);

        Course course2 = new Course(1, "Course Name", "Instructor Name", new Date(),
                "Location", TypeCourse.THEORY, null,
                new ArrayList<>(), new ArrayList<>(), null);

        Course course3 = new Course(2, "Another Course", "Another Instructor", new Date(),
                "Another Location", TypeCourse.PRACTICE, null,
                new ArrayList<>(), new ArrayList<>(), null);

        // Vérifier les codes de hachage
        assertEquals(course1.hashCode(), course2.hashCode()); // Doit être le même
        assertNotEquals(course1.hashCode(), course3.hashCode()); // Ne doit pas être le même
    }
}