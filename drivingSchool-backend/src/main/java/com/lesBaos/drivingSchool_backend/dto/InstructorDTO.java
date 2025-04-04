package com.lesBaos.drivingSchool_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InstructorDTO {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    @JsonIgnore
    private String password;

    private String phone;

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
}
