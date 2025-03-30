package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Planning;
import com.lesBaos.drivingSchool_backend.dto.PlanningDTO;

import java.util.List;

public interface PlanningService {

    public PlanningDTO createPlanning(PlanningDTO planningDTO);
    public Planning updatePlanning(Long id, Planning planning);
    public Planning findPlanningById(Long id);
    public List<Planning> findAllPlannings();
    public void deletePlanning(Long id);
}
