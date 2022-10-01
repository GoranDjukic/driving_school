package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.model.DrivingSchool;
import com.gorandjukic.drivingSchool.service.DrivingSchoolService;
import com.gorandjukic.drivingSchool.support.DrivingSchoolToDrivingSchoolDto;
import com.gorandjukic.drivingSchool.web.dto.DrivingSchoolDto;
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
    private DrivingSchoolToDrivingSchoolDto toDrivingSchoolDto;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DrivingSchoolDto>> getAll(
            @RequestParam(required = false) String name) {

        List<DrivingSchool> drivingSchoolList = drivingSchoolService.all();

        return new ResponseEntity<>(toDrivingSchoolDto.convert(drivingSchoolList), HttpStatus.OK);
    }
}
