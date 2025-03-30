package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.data.Payment;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    public void testToString() {
        // Créer une instance de Administrator pour le paiement
        Administrator admin = new Administrator();
        admin.setId(1); // Supposons que l'administrateur a un ID de 1

        // Créer une instance de Payment
        Payment payment = new Payment(1, new Date(), 100.0, "REF123456", admin);

        // Construire le résultat attendu de toString()
        String expected = "Payment{" +
                "id=1" +
                ", date=" + payment.getDate() +
                ", amount=100.0" +
                ", reference='REF123456'" +
                ", administrator=" + admin.getId() +
                '}';

        // Vérifier que le résultat de toString() est conforme aux attentes
        assertEquals(expected, payment.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux instances de Administrator pour le paiement
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        Administrator admin2 = new Administrator();
        admin2.setId(2);

        // Créer deux paiements avec le même ID
        Payment payment1 = new Payment(1, new Date(), 100.0, "REF123456", admin1);
        Payment payment2 = new Payment(1, new Date(), 200.0, "REF654321", admin1);
        Payment payment3 = new Payment(2, new Date(), 150.0, "REF111222", admin2);

        // Vérifier que payment1 et payment2 sont égaux en raison du même ID
        assertEquals(payment1, payment2); // Doit être égal
        // Vérifier que payment1 et payment3 ne sont pas égaux
        assertNotEquals(payment1, payment3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des instances de Administrator pour le paiement
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        // Créer des paiements
        Payment payment1 = new Payment(1, new Date(), 100.0, "REF123456", admin1);
        Payment payment2 = new Payment(1, new Date(), 200.0, "REF654321", admin1);
        Payment payment3 = new Payment(2, new Date(), 150.0, "REF111222", admin1);

        // Vérifier que les hashcodes de payment1 et payment2 sont identiques à cause du même ID
        assertEquals(payment1.hashCode(), payment2.hashCode()); // Doit être le même
        // Vérifier que le hashcode de payment1 est différent de payment3
        assertNotEquals(payment1.hashCode(), payment3.hashCode()); // Ne doit pas être le même
    }
}