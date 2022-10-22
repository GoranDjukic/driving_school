package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.support.TraineeToTraineeDto;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import com.gorandjukic.drivingSchool.web.response.TraineeResponse;
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

    @GetMapping
    public ResponseEntity<List<TraineeResponse>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "999") int size) {
        Page<Trainee> traineeList = traineeService.all(page, size);

        return new ResponseEntity<>(toTraineeDto.convert(traineeList.getContent()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<TraineeResponse> getOne(@PathVariable Long id) {
        Optional<Trainee> trainee = traineeService.one(id);

        return new ResponseEntity<>(toTraineeDto.convert(trainee.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TraineeResponse> save(@RequestBody TraineeRequest request) {
        Trainee saved = traineeService.save(request);

        return new ResponseEntity<TraineeResponse>(toTraineeDto.convert(saved), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TraineeResponse> update(
            @PathVariable Long id,
            @RequestBody TraineeRequest request) {
        Trainee persisted = traineeService.update(request, id);

        return new ResponseEntity<>(toTraineeDto.convert(persisted), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        traineeService.delete(id);

        return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TraineeResponse> getTraineesByDsOrName(
            @RequestParam Long drivingSchoolId,
            @RequestParam String traineeName
    ) {

        return traineeService.getTraineesByDsOrName(
                drivingSchoolId,
                traineeName
        );
    }
}


