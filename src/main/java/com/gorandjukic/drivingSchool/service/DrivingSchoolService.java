package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.model.DrivingSchool;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DrivingSchoolService {
    List<DrivingSchool> all();
}
