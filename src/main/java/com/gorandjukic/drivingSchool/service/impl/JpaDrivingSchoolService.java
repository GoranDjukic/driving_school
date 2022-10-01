package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.model.DrivingSchool;
import com.gorandjukic.drivingSchool.repository.DrivingSchoolRepository;
import com.gorandjukic.drivingSchool.service.DrivingSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaDrivingSchoolService implements DrivingSchoolService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Override
    public List<DrivingSchool> all() {
        return drivingSchoolRepository.findAll() ;
    }
}
