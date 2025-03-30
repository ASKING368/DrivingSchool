package com.lesBaos.drivingSchool_backend.controller;

import com.lesBaos.drivingSchool_backend.data.Support;
import com.lesBaos.drivingSchool_backend.dto.SupportDTO;
import com.lesBaos.drivingSchool_backend.service.SupportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supports") // Regroupe tous les endpoints sous une même route
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping
    public ResponseEntity<SupportDTO> createSupport(@RequestBody SupportDTO supportDTO) {
        SupportDTO createdSupport = supportService.createSupport(supportDTO);
        return new ResponseEntity<>(createdSupport, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Support> updateSupport(@PathVariable Long id, @RequestBody Support support) {
        Support updatedSupport = supportService.updateSupport(id, support);
        return new ResponseEntity<>(updatedSupport, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Support> findSupportById(@PathVariable Long id) {
        Support support = supportService.findSupportById(id);
        return support != null ?
                new ResponseEntity<>(support, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Support>> findAllSupports() {
        List<Support> supports = supportService.findAllSupports();
        return new ResponseEntity<>(supports, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Long id) {
        if (supportService.findSupportById(id) != null) {
            supportService.deleteSupport(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}