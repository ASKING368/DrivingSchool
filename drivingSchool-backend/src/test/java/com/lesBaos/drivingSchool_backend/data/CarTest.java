package com.lesBaos.drivingSchool_backend.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CarTest {

   /* @Test
    public void testToString() {
        // Créer une instance de Car
        Car car = new Car();
        car.setId(1);
        car.setBrand("Toyota");
        car.setModel("Corolla");
        car.setColor("Red");
        car.setRegistration("ABC123");
        car.setStatut(CarStatus.AVAILABLE);
        car.setAdministrator(null);

        // Vérifier le résultat de toString()
        String expected = "Car{id=1, brand='Toyota', model='Corolla', color='Red', registration='ABC123', statut=AVAILABLE, administrator=null}";
        assertEquals(expected, car.toString());
    }*/

    @Test
    public void testEquals() {
        // Créer deux instances de Car avec le même ID
        Car car1 = new Car("Toyota", "Corolla", "Red", "ABC123", CarStatus.AVAILABLE, null);
        car1.setId(1); // Simulez un ID

        Car car2 = new Car("Toyota", "Corolla", "Red", "ABC123", CarStatus.AVAILABLE, null);
        car2.setId(1); // Simulez le même ID

        Car car3 = new Car("Honda", "Civic", "Blue", "XYZ789", CarStatus.UNAVAILABLE, null);
        car3.setId(2); // Simulez un autre ID

        // Vérifier l'égalité
        assertEquals(car1, car2); // Dois être égal
        assertNotEquals(car1, car3); // Ne dois pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer une instance de Car
        Car car1 = new Car("Toyota", "Corolla", "Red", "ABC123", CarStatus.AVAILABLE, null);
        car1.setId(1); // Simulez un ID

        Car car2 = new Car("Toyota", "Corolla", "Red", "ABC123", CarStatus.AVAILABLE, null);
        car2.setId(1); // Simulez le même ID

        Car car3 = new Car("Honda", "Civic", "Blue", "XYZ789", CarStatus.UNAVAILABLE, null);
        car3.setId(2); // Simulez un autre ID

        // Vérifier les codes de hachage
        assertEquals(car1.hashCode(), car2.hashCode()); // Doit être le même
        assertNotEquals(car1.hashCode(), car3.hashCode()); // Ne doit pas être le même
    }
}