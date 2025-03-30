package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Administrator implements Serializable {

//******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "administrator", fetch = FetchType.LAZY)
    private List<Payment> payments;

    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
    private List<Car> cars;

    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToMany (mappedBy = "administrator", fetch = FetchType.LAZY)
    private List<Support> supports;

//******************************************* CONSTRUCTORS ************************************************************

    public Administrator() {}

    public Administrator(String firstName, long id, String lastName, String email, String password, String phone, List<Payment> payments, List<Car> cars, List<Course> courses, List<Support> supports) {
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.payments = payments;
        this.cars = cars;
        this.courses = courses;
        this.supports = supports;
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

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Administrator)) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}