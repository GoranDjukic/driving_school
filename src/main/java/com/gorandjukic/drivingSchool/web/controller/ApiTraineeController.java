package com.gorandjukic.drivingSchool.web.controller;


import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.support.TraineeToTraineeDto;
import com.gorandjukic.drivingSchool.web.dto.TraineeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/trainee")
public class ApiTraineeController {

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private TraineeToTraineeDto toTraineeDto;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TraineeDto>> getAll(
            @RequestParam(value = "traineeName", required = false) String traineeName,
            @RequestParam(value = "drivingSchoolId", required = false) Long drivingSchoolId,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Page<Trainee> traineeList = traineeService.all(page);

        return new ResponseEntity<>(toTraineeDto.convert(traineeList.getContent()), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<TraineeDto> getOne(@PathVariable Long id) {
        Optional<Trainee> trainee = traineeService.one(id);

        if (!trainee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(toTraineeDto.convert(trainee.get()), HttpStatus.OK);
    }

    // add

    // update

    // delete

}
