package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Size(max = 100)
    @NotNull
    private String email;

    @Size(max = 25)
    @NotNull
    private String password;

    // Constructeur par défaut
    public User() {
    }

    public User(long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    //******************************************* GETTERS AND SETTERS ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id; // Comparaison basée sur l'ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne un code de hachage basé sur l'ID
    }
}