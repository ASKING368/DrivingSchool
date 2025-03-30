package com.lesBaos.drivingSchool_backend.data;

import com.lesBaos.drivingSchool_backend.enumerations.TypeCourse;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String instructorName;

    @NotNull
    @Column(nullable = false)
    private Date date;

    @NotNull
    @Column(nullable = false)
    private String location;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCourse typeCourse;

    @ManyToOne
    private Administrator administrator;

    @ManyToMany
    private List<Instructor> instructors;

    @ManyToMany
    private List<Candidate> candidates;

    @ManyToOne
    private Planning planning;

    public Course() {
    }

    public Course(long id, String name, String instructorName, Date date, String location, TypeCourse typeCourse,
                  Administrator administrator, List<Instructor> instructors, List<Candidate> candidates, Planning planning) {
        this.id = id;
        this.name = name;
        this.instructorName = instructorName;
        this.date = date;
        this.location = location;
        this.typeCourse = typeCourse;
        this.administrator = administrator;
        this.instructors = instructors;
        this.candidates = candidates;
        this.planning = planning;
    }

    // Getters et Setters
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

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TypeCourse getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(TypeCourse typeCourse) {
        this.typeCourse = typeCourse;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", typeCourse=" + typeCourse +
                ", administrator=" + (administrator != null ? administrator.getId() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}