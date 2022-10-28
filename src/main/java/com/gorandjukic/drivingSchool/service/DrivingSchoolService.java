package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;

import java.util.List;

public interface DrivingSchoolService {
    List<DrivingSchool> all();

    List<ExamResponse> getExamsByDrivingSchoolId(Long drivingSchoolId);
}
