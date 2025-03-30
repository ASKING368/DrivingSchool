package com.lesBaos.drivingSchool_backend.serviceImplement;

import com.lesBaos.drivingSchool_backend.dao.SupportRepository;
import com.lesBaos.drivingSchool_backend.data.Support;
import com.lesBaos.drivingSchool_backend.dto.SupportDTO;
import com.lesBaos.drivingSchool_backend.mappers.Mappers;
import com.lesBaos.drivingSchool_backend.service.SupportService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class SupportImplement implements SupportService {

    private final SupportRepository supportRepository;
    private final Mappers mappers;

    public SupportImplement(SupportRepository supportRepository, Mappers mappers) {
        this.supportRepository = supportRepository;
        this.mappers = mappers;
    }

    @Override
    public SupportDTO createSupport(SupportDTO supportDTO) {
        Support support = mappers.fromSupportDTO(supportDTO);
        return mappers.fromSupport(supportRepository.save(support));
    }

    @Override
    public Support updateSupport(Long id, Support support) {
        Support support1 = findSupportById(id);
        support1.setName(support.getName());
        support1.setTypeSupport(support.getTypeSupport());
        return supportRepository.save(support1);
    }

    @Override
    public Support findSupportById(Long id) {
        return supportRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The support with id %s not found", id))
        );
    }

    @Override
    public List<Support> findAllSupports() {
        return supportRepository.findAll();
    }

    @Override
    public void deleteSupport(Long id) {
        Support support = findSupportById(id);
        supportRepository.delete(support);
    }
}
