package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.data.Planning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlanningTest {

    @Test
    public void testToString() {
        // Créer une instance de Administrator pour le planning
        Administrator admin = new Administrator();
        admin.setId(1); // Supposons que l'administrateur a un ID de 1

        // Créer une instance de Planning
        Planning planning = new Planning(1, "Planning Title", admin);

        // Vérifier le résultat de toString()
        String expected = "Planning{" +
                "id=1" +
                ", title='Planning Title'" +
                ", administrator=1" +
                '}';

        // Vérifier que le résultat de toString() est conforme aux attentes
        assertEquals(expected, planning.toString());
    }

    @Test
    public void testEquals() {
        // Créer deux instances de Administrator pour le planning
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        Administrator admin2 = new Administrator();
        admin2.setId(2);

        // Créer deux plannings avec le même ID et des titres différents
        Planning planning1 = new Planning(1, "Planning 1", admin1);
        Planning planning2 = new Planning(1, "Planning 2", admin1);
        Planning planning3 = new Planning(2, "Planning 3", admin2);

        // Vérifier que planning1 et planning2 sont égaux (même ID)
        assertEquals(planning1, planning2); // Doit être égal
        // Vérifier que planning1 et planning3 ne sont pas égaux (ID différent)
        assertNotEquals(planning1, planning3); // Ne doit pas être égal
    }

    @Test
    public void testHashCode() {
        // Créer des instances de Administrator pour le planning
        Administrator admin1 = new Administrator();
        admin1.setId(1);

        // Créer des plannings
        Planning planning1 = new Planning(1, "Planning 1", admin1);
        Planning planning2 = new Planning(1, "Planning 2", admin1);
        Planning planning3 = new Planning(2, "Planning 3", admin1);

        // Vérifier que les hashcodes de planning1 et planning2 sont identiques à cause du même ID
        assertEquals(planning1.hashCode(), planning2.hashCode()); // Doit être le même
        // Vérifier que le hashcode de planning1 est différent de planning3
        assertNotEquals(planning1.hashCode(), planning3.hashCode()); // Ne doit pas être le même
    }
}