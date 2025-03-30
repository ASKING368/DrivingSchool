package com.lesBaos.drivingSchool_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdministratorDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    @JsonIgnore
    private String password;
    private String phone;
}
