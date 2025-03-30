package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.dto.AdministratorDTO;

import java.util.List;


public interface AdministratorService {

    public AdministratorDTO createAdministrator(AdministratorDTO administratorDTO);
    public Administrator updateAdministrator(Long id, Administrator administrator);
    public Administrator findAdministratorById(Long id);
    public List<Administrator> findAllAdministrators();
    public void deleteAdministrator(Long id);



}
