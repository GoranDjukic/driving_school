package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.service.DrivingSchoolService;
import com.gorandjukic.drivingSchool.service.ExamService;
import com.gorandjukic.drivingSchool.support.DrivingSchoolToDrivingSchoolDto;
import com.gorandjukic.drivingSchool.web.response.DrivingSchoolResponse;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/driving-schools")
public class ApiDrivingSchoolController {

    @Autowired
    private DrivingSchoolService drivingSchoolService;
    @Autowired
    private ExamService examService;
    @Autowired
    private DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto;

    @RequestMapping
    public ResponseEntity<List<DrivingSchoolResponse>> getAll() {

        List<DrivingSchool> drivingSchoolList = drivingSchoolService.all();

        return new ResponseEntity<>(toDrivingSchoolDto.convert(drivingSchoolList), HttpStatus.OK);
    }

    @GetMapping("{id}/exams")
    public ResponseEntity<List<ExamResponse>> getExamsByDrivingSchoolId(
            @PathVariable("id") Long drivingSchoolId) {
        return new ResponseEntity<>(drivingSchoolService.getExamsByDrivingSchoolId(drivingSchoolId), HttpStatus.OK);
    }
}
