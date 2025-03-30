package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.PlanningRepository;
import com.lesBaos.drivingSchool_backend.data.Planning;
import com.lesBaos.drivingSchool_backend.dto.PlanningDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class PlanningServiceImplement implements PlanningService {

    private final PlanningRepository planningRepository;
    private final Mappers mappers;

    public PlanningServiceImplement(PlanningRepository planningRepository, Mappers mappers) {
        this.planningRepository = planningRepository;
        this.mappers = mappers;
    }

    @Override
    public PlanningDTO createPlanning(PlanningDTO planningDTO) {
        Planning planning = mappers.fromPlanningDTO(planningDTO);
        return mappers.fromPlanning(planningRepository.save(planning));
    }

    @Override
    public Planning updatePlanning(Long id, Planning planning) {
        Planning planning1 = findPlanningById(id);
        planning1.setTitle(planning.getTitle());
        return planningRepository.save(planning1);
    }

    @Override
    public Planning findPlanningById(Long id) {
        return planningRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Planning with id %d not found", id))
        );
    }

    @Override
    public List<Planning> findAllPlannings() {
        return planningRepository.findAll();
    }

    @Override
    public void deletePlanning(Long id) {
        Planning planning = findPlanningById(id);
        planningRepository.delete(planning);
    }
}
