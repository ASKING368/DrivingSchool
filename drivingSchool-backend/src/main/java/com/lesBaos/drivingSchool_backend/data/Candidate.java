package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.enumerations.TypeCandidate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Candidate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @NotNull
    @Size(min = 8) // Exige un mot de passe d’au moins 8 caractères
    private String password;

    @NotNull
    private String phone;

    @Enumerated(EnumType.STRING)
    private TypeCandidate typeCandidate;

    @ManyToMany (mappedBy = "candidates")
    private List<Support> supports;

    @ManyToMany (mappedBy = "candidates")
    private List<Planning> plannings;

    @ManyToMany (mappedBy = "candidates")
    private List<Course> courses;

//******************************************* CONSTRUCTORS ************************************************************

    public Candidate() {
    }

    public Candidate(long id, String firstName, String lastName, String email, String password, String phone, List<Support> supports, List<Planning> plannings, List<Course> courses, TypeCandidate typeCandidate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.supports = supports;
        this.plannings = plannings;
        this.courses = courses;
        this.typeCandidate = typeCandidate;
    }

//******************************************* GETTERS AND SETTERS ************************************************************

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeCandidate getTypeCandidate() {
        return typeCandidate;
    }

    public void setTypeCandidate(TypeCandidate type) {
        this.typeCandidate = type;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", typeCandidate=" + typeCandidate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est la même instance
        if (!(o instanceof Candidate)) return false; // Vérifie la classe correcte
        Candidate candidate = (Candidate) o; // Cast vers Candidate
        return id == candidate.id; // Vérifie si les IDs sont les mêmes
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Génère un code de hachage basé sur l'ID
    }
}