package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @ManyToMany(mappedBy = "instructors")
    private List<Car> cars;

    @ManyToMany(mappedBy = "instructors")
    private List<Planning> plannings;

    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;

    @ManyToMany(mappedBy = "instructors")
    private List<Support> supports;

    public Instructor() {
    }

    public Instructor(long id, String firstName, String lastName, String email, String password,
                      String phone, List<Car> cars, List<Planning> plannings,
                      List<Course> courses, List<Support> supports) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.cars = cars;
        this.plannings = plannings;
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
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", cars=" + (cars != null ? cars.size() : 0) + " cars" +
                ", plannings=" + (plannings != null ? plannings.size() : 0) + " plannings" +
                ", courses=" + (courses != null ? courses.size() : 0) + " courses" +
                ", supports=" + (supports != null ? supports.size() : 0) + " supports" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return id == that.id; // Comparaison basée sur l'ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne un code de hachage basé sur l'ID
    }
}