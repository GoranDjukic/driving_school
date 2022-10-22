package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.repository.ExamRepository;
import com.gorandjukic.drivingSchool.service.ExamService;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }



}
