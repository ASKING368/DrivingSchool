package com.lesBaos.drivingSchool_backend.controller;

import com.lesBaos.drivingSchool_backend.data.Planning;
import com.lesBaos.drivingSchool_backend.dto.PlanningDTO;
import com.lesBaos.drivingSchool_backend.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plannings") // Regroupe tous les endpoints sous une même route
public class PlanningController {

    private final PlanningService planningService;

    public PlanningController(PlanningService planningService) {
        this.planningService = planningService;
    }

    @PostMapping
    public ResponseEntity<PlanningDTO> createPlanning(@RequestBody PlanningDTO planningDTO) {
        PlanningDTO createdPlanning = planningService.createPlanning(planningDTO);
        return new ResponseEntity<>(createdPlanning, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planning> updatePlanning(@PathVariable Long id, @RequestBody Planning planning) {
        Planning updatedPlanning = planningService.updatePlanning(id, planning);
        return new ResponseEntity<>(updatedPlanning, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Planning> findPlanningById(@PathVariable Long id) {
        Planning planning = planningService.findPlanningById(id);
        return planning != null ?
                new ResponseEntity<>(planning, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Planning>> findAllPlannings() {
        List<Planning> plannings = planningService.findAllPlannings();
        return new ResponseEntity<>(plannings, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlanning(@PathVariable Long id) {
        if (planningService.findPlanningById(id) != null) {
            planningService.deletePlanning(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}