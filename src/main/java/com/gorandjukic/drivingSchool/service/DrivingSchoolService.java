package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrivingSchoolService {
    List<DrivingSchool> all();

    List<ExamResponse> getExamsByDrivingSchoolId(Long drivingSchoolId);
}
