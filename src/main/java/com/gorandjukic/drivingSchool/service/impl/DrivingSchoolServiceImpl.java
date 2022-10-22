package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.repository.DrivingSchoolRepository;
import com.gorandjukic.drivingSchool.service.DrivingSchoolService;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivingSchoolServiceImpl implements DrivingSchoolService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Override
    public List<DrivingSchool> all() {
        return drivingSchoolRepository.findAll();
    }

    @Override
    public List<ExamResponse> getExamsByDrivingSchoolId(Long drivingSchoolId) {
        return drivingSchoolRepository.getExamsByDrivingSchoolId(drivingSchoolId);
    }
}

