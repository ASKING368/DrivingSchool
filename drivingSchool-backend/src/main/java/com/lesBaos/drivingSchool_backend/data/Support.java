package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.enumerations.TypeSupport;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Support {
    //******************************************* ATTRIBUTS ************************************************************

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // Assurez-vous que le TypeSupport soit bien mappé
    private TypeSupport typeSupport;

    @ManyToOne
    private Administrator administrator;

    @ManyToMany
    private List<Instructor> instructors;

    @ManyToMany
    private List<Candidate> candidates;

    //******************************************* CONSTRUCTORS ************************************************************

    public Support() {
    }

    public Support(long id, String name, TypeSupport typeSupport, Administrator administrator, List<Instructor> instructors, List<Candidate> candidates) {
        this.id = id;
        this.name = name;
        this.typeSupport = typeSupport;
        this.administrator = administrator;
        this.instructors = instructors;
        this.candidates = candidates;
    }

    //******************************************* GETTERS AND SETTERS ************************************************************

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeSupport getTypeSupport() {
        return typeSupport;
    }

    public void setTypeSupport(TypeSupport typeSupport) {
        this.typeSupport = typeSupport;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public String toString() {
        return "Support{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeSupport=" + typeSupport +
                ", administrator=" + (administrator != null ? administrator.getId() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Support)) return false;
        Support support = (Support) o;
        return id == support.id; // Comparaison basée sur l'ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Retourne un code de hachage basé sur l'ID
    }
}