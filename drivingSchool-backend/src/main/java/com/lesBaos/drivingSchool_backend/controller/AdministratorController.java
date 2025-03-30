package com.lesBaos.drivingSchool_backend.controller;

import com.lesBaos.drivingSchool_backend.data.Administrator;
import com.lesBaos.drivingSchool_backend.dto.AdministratorDTO;
import com.lesBaos.drivingSchool_backend.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrators") // Meilleure pratique : grouper les endpoints
public class AdministratorController {

    private final AdministratorService administratorService;

    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @PostMapping
    public ResponseEntity<AdministratorDTO> createAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        AdministratorDTO createdAdministrator = administratorService.createAdministrator(administratorDTO);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        Administrator updatedAdministrator = administratorService.updateAdministrator(id, administrator);
        return new ResponseEntity<>(updatedAdministrator, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> findAdministratorById(@PathVariable Long id) {
        Administrator administrator = administratorService.findAdministratorById(id);
        return administrator != null ?
                new ResponseEntity<>(administrator, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Administrator>> findAllAdministrators() {
        List<Administrator> administrators = administratorService.findAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        if (administratorService.findAdministratorById(id) != null) {
            administratorService.deleteAdministrator(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}