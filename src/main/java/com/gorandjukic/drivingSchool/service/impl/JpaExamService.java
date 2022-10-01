package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.Exam;
import com.gorandjukic.drivingSchool.repository.ExamRepository;
import com.gorandjukic.drivingSchool.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaExamService implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public List<Exam> all() {
        return examRepository.findAll();
    }

    @Override
    public Page<Exam> search(Long drivingSchoolId, int page) {
        return examRepository.search(drivingSchoolId, PageRequest.of(page, 2));
    }


}
