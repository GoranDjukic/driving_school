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
// todo verzionisanje
@RequestMapping(value = "/api/driving-schools")
public class ApiDrivingSchoolController {

    private final DrivingSchoolService drivingSchoolService;
    private final ExamService examService;
    private final DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto;

    public ApiDrivingSchoolController(
            DrivingSchoolService drivingSchoolService,
            ExamService examService,
            DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto
    ) {
        this.drivingSchoolService = drivingSchoolService;
        this.examService = examService;
        this.toDrivingSchoolDto = toDrivingSchoolDto;
    }

    @GetMapping
    public ResponseEntity<List<DrivingSchoolResponse>> getAll() {
        List<DrivingSchool> drivingSchoolList = drivingSchoolService.all();
        return new ResponseEntity<>(toDrivingSchoolDto.convert(drivingSchoolList), HttpStatus.OK);
    }

    @GetMapping("/{id}/exams")
    public ResponseEntity<List<ExamResponse>> getExamsByDrivingSchoolId(
            @PathVariable Long drivingSchoolId) {
        return new ResponseEntity<>(drivingSchoolService.getExamsByDrivingSchoolId(drivingSchoolId), HttpStatus.OK);
    }

}
