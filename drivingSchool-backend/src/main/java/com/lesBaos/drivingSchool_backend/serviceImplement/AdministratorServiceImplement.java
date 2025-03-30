package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.AdministratorRepository;
import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.dto.AdministratorDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class AdministratorServiceImplement implements AdministratorService {

    private final AdministratorRepository administratorRepository;
    private final Mappers mappers;

    public AdministratorServiceImplement(AdministratorRepository administratorRepository, Mappers mappers) {
        this.administratorRepository = administratorRepository;
        this.mappers = mappers;
    }

    @Override
    public AdministratorDTO createAdministrator(AdministratorDTO administratorDTO) {
        Administrator administrator = mappers.fromAdministratorDTO(administratorDTO);
        return mappers.fromAdministrator(administratorRepository.save(administrator));
    }

    @Override
    public Administrator updateAdministrator(Long id, Administrator administrator) {
        Administrator administrator1 = this.findAdministratorById(id);
        administrator1.setFirstName(administrator.getFirstName());
        administrator1.setLastName(administrator.getLastName());
        administrator1.setEmail(administrator.getEmail());
        administrator1.setPhone(administrator.getPhone());
        administrator1.setPassword(administrator.getPassword());
        return administratorRepository.save(administrator1);
    }

    @Override
    public Administrator findAdministratorById(Long id) {
        return administratorRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Administrator with ID %s not found", id))
        );
    }


    @Override
    public List<Administrator> findAllAdministrators() {
        return administratorRepository.findAll();
    }

    @Override
    public void deleteAdministrator(Long id) {
    Administrator administrator = this.findAdministratorById(id);
    administratorRepository.delete(administrator);
    }
}
