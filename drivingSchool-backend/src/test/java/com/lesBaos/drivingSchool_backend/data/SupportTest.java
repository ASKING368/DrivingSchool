package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.data.Support;
import com.lesBaos.drivingSchool_backend.enumerations.TypeSupport;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class SupportTest {

    @Test
    public void testToString() {
        // Créer une instance de Administrator pour le support
        Administrator admin = new Administrator();
        admin.setId(1); // Supposons que l'administrateur a un ID de 1

        // Créer une instance de Support
        Support support = new Support(1, "Support Name", TypeSupport.SOME_TYPE, admin, Collections.emptyList(), Collections.emptyList());

        // Vérifier le résultat de toString()
        String expected = "Support{" +
                "id=1" +
                ", name='Support Name'" +
                ", typeSupport=SOME_TYPE" +
                ", administrator=1" +
                '}';

        // Vérifier que le résultat de toString() est conforme aux attentes
        assertEquals(expected, support.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux instances de Administrator pour le support
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        Administrator admin2 = new Administrator();
        admin2.setId(2);

        // Créer deux supports avec le même ID
        Support support1 = new Support(1, "Support 1", TypeSupport.SOME_TYPE, admin1, Collections.emptyList(), Collections.emptyList());
        Support support2 = new Support(1, "Support 2", TypeSupport.SOME_TYPE, admin1, Collections.emptyList(), Collections.emptyList());
        Support support3 = new Support(2, "Support 3", TypeSupport.ANOTHER_TYPE, admin2, Collections.emptyList(), Collections.emptyList());

        // Vérifier que support1 et support2 sont égaux (même ID)
        assertEquals(support1, support2); // Doit être égal
        // Vérifier que support1 et support3 ne sont pas égaux (ID différent)
        assertNotEquals(support1, support3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des instances de Administrator pour le support
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        // Créer des supports
        Support support1 = new Support(1, "Support 1", TypeSupport.SOME_TYPE, admin1, Collections.emptyList(), Collections.emptyList());
        Support support2 = new Support(1, "Support 2", TypeSupport.SOME_TYPE, admin1, Collections.emptyList(), Collections.emptyList());
        Support support3 = new Support(2, "Support 3", TypeSupport.ANOTHER_TYPE, admin1, Collections.emptyList(), Collections.emptyList());

        // Vérifier que les hashcodes de support1 et support2 sont identiques à cause du même ID
        assertEquals(support1.hashCode(), support2.hashCode()); // Doit être le même
        // Vérifier que le hashcode de support1 est différent de support3
        assertNotEquals(support1.hashCode(), support3.hashCode()); // Ne doit pas être le même
    }
}