package com.lesBaos.drivingSchool_backend.service;

import com.lesBaos.drivingSchool_backend.data.Support;
import com.lesBaos.drivingSchool_backend.dto.SupportDTO;

import java.util.List;

public interface SupportService {

    public SupportDTO createSupport(SupportDTO supportDTO);
    public Support updateSupport(Long id, Support support);
    public Support findSupportById(Long id);
    public List<Support> findAllSupports();
    public void deleteSupport(Long id);
}
