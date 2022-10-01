package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.model.Exam;
import com.gorandjukic.drivingSchool.service.ExamService;
import com.gorandjukic.drivingSchool.support.ExamToExamDto;
import com.gorandjukic.drivingSchool.web.dto.ExamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/driving-schools/{id}/exams")
public class ApiExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamToExamDto toExamDto;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ExamDto>> getAll
            (@RequestParam(value = "drivingSchoolId", required = true) Long drivingSchoolId,
             @RequestParam(value = "page", defaultValue = "0") int page) {

        Page<Exam> examPage = examService.search(drivingSchoolId, page);

        return new ResponseEntity<>(toExamDto.convert(examPage.getContent()), HttpStatus.OK);
    }

}
