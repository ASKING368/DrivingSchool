package com.lesBaos.drivingSchool_backend.dto;

import com.lesBaos.drivingSchool_backend.enumerations.TypeSupport;

public class SupportDTO {
    private Long id;

    private String name;

    private TypeSupport typeSupport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
