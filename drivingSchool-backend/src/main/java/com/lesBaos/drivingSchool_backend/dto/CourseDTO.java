package com.lesBaos.drivingSchool_backend.dto;

import java.util.Date;

public class CourseDTO {
    private Long id;
    private String name;
    private Date date;
    private String location;
    private String type;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}
}
