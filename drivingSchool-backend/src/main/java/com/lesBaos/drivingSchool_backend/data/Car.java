package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Car implements Serializable {

    //******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String brand;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false)
    private String model;

    @NotNull
    @Size(max = 20)
    @Column(nullable = false)
    private String color;

    @NotNull
    @Size(max = 15) // Taille maximale pour l'immatriculation
    @Column(nullable = false, unique = true)
    private String registration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarStatus statut;

    @ManyToOne
    private Administrator administrator;

    @ManyToMany
    private List<Instructor> instructors;

//******************************************* CONSTRUCTORS ************************************************************

    public Car() {
    }

    public Car(String brand, String model, String color, String registration, CarStatus statut, Administrator administrator) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registration = registration;
        this.statut = statut;
        this.administrator = administrator;
    }

//******************************************* GETTERS AND SETTERS ************************************************************

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public String getRegistration() {return registration;}
    public void setRegistration(String registration) {this.registration = registration;}

    public CarStatus getStatut() {return statut;}
    public void setStatut(CarStatus statut) {this.statut = statut;}

    public Administrator getAdministrator() {return administrator;}
    public void setAdministrator(Administrator administrator) {this.administrator = administrator;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", registration='" + registration + '\'' +
                ", status=" + statut + '\'' +
                ", administrator=" + administrator + '\'' +
                ", instructors=" + instructors + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Vérifie si c'est la même instance
        if (!(o instanceof Car)) return false; // Vérifie la classe correcte
        Car car = (Car) o; // Cast vers Car
        return id == car.id; // Vérifie si les IDs sont les mêmes
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Génère un code de hachage basé sur l'ID
    }
}