package com.lesBaos.drivingSchool_backend.dto;

import java.util.Date;

public class PaymentDTO {
    private Long id;

    private Date date;

    private double amount;

    private String reference;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Date getDate() {return date;}
    public void setDate(Date date) {this.date = date;}

    public double getAmount() {return amount;}
    public void setAmount(double amount) {this.amount = amount;}

    public String getReference() {return reference;}
    public void setReference(String reference) {this.reference = reference;}
}
