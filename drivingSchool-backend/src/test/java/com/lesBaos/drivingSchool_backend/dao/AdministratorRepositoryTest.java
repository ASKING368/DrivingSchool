package com.lesBaos.drivingSchool_backend.dao;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AdministratorRepositoryTest {

    @Autowired
    private AdministratorRepository administratorRepository;

    private Administrator testAdmin;

    @BeforeEach
    public void setUp() {
        testAdmin = new Administrator();
        testAdmin.setFirstName("John");
        testAdmin.setLastName("Doe");
        testAdmin.setEmail("john.doe@xyz.com");
        testAdmin.setPassword("password123");
        testAdmin.setPhone("267639929");
    }

    @Test
    @Rollback(false) // Le rollback est désactivé pour conserver les données insérées
    public void testCreateAdministrator() {
        Administrator savedAdmin = administratorRepository.save(testAdmin);
        assertThat(savedAdmin).isNotNull();
        assertThat(savedAdmin.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAdministratorById() {
        Administrator savedAdmin = administratorRepository.save(testAdmin);
        Optional<Administrator> foundAdmin = administratorRepository.findById(savedAdmin.getId());
        assertThat(foundAdmin).isPresent();
        assertThat(foundAdmin.get().getFirstName()).isEqualTo(testAdmin.getFirstName());
    }

    @Test
    public void testUpdateAdministrator() {
        Administrator savedAdmin = administratorRepository.save(testAdmin);
        savedAdmin.setFirstName("Jane"); // Changer le prénom pour tester une vraie mise à jour
        Administrator updatedAdmin = administratorRepository.save(savedAdmin);

        assertThat(updatedAdmin.getFirstName()).isEqualTo("Jane");
    }

    @Test
    public void testDeleteAdministrator() {
        Administrator savedAdmin = administratorRepository.save(testAdmin);
        Long adminId = savedAdmin.getId();
        administratorRepository.deleteById(adminId);

        Optional<Administrator> deletedAdmin = administratorRepository.findById(adminId);
        assertThat(deletedAdmin).isNotPresent();
    }
}