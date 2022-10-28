package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.service.DrivingSchoolService;
import com.gorandjukic.drivingSchool.support.DrivingSchoolToDrivingSchoolDto;
import com.gorandjukic.drivingSchool.web.response.DrivingSchoolResponse;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// todo verzionisanje
@RequestMapping(value = "/api/driving-schools")
public class DrivingSchoolController {

    private final DrivingSchoolService drivingSchoolService;
    private final DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto;

    public DrivingSchoolController(
            DrivingSchoolService drivingSchoolService,
            DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto
    ) {
        this.drivingSchoolService = drivingSchoolService;
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
