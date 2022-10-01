package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.domain.Exam;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExamService {
    List<Exam> all();

    Page<Exam> search (Long drivingSchoolId, int page);
}
