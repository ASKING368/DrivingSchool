package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, unique = true)
    private String reference; // Ajout d'une contrainte d'unicité sur la référence

    @ManyToOne
    private Administrator administrator;

    // Constructeur par défaut
    public Payment() {
    }

    // Constructeur avec paramètres
    public Payment(long id, Date date, double amount, String reference, Administrator administrator) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.reference = reference;
        this.administrator = administrator;
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                ", administrator=" + (administrator != null ? administrator.getId() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return id == payment.id; // Comparaison basée sur l'ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne un code de hachage basé sur l'ID
    }
}