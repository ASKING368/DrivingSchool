package com.lesBaos.drivingSchool_backend.dto;

public class CarDTO {
    public Long id;
    public String brand;
    public String model;
    public String color;
    public String registrator;
    public String statut;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    public String getRegistrator() {return registrator;}
    public void setRegistrator(String registrator) {this.registrator = registrator;}

    public String getStatut() {return statut;}
    public void setStatut(String statut) {this.statut = statut;}
}
