package com.lesBaos.drivingSchool_backend.data;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Planning implements Serializable {
    //******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private Administrator administrator;

    @ManyToMany
    private List<Instructor> instructors;

    @ManyToMany
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "planning")
    private List<Course> courses;

    //******************************************* CONSTRUCTORS ************************************************************

    public Planning() {
    }

    public Planning(long id, String title, Administrator administrator) {
        this.id = id;
        this.title = title;
        this.administrator = administrator;
    }

    //******************************************* GETTERS AND SETTERS ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Planning{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", administrator=" + (administrator != null ? administrator.getId() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Planning)) return false;
        Planning planning = (Planning) o;
        return id == planning.id; // Comparaison basée sur l'ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne un code de hachage basé sur l'ID
    }
}