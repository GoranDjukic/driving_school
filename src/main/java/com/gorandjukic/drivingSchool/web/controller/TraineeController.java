package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.support.TraineeToTraineeDto;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import com.gorandjukic.drivingSchool.web.response.TraineeDtoProjection;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/trainee")
public class TraineeController {

    private final TraineeService traineeService;
    private final TraineeToTraineeDto toTraineeDto;

    public TraineeController(
            TraineeService traineeService,
            TraineeToTraineeDto toTraineeDto
    ) {
        this.traineeService = traineeService;
        this.toTraineeDto = toTraineeDto;
    }

    @GetMapping
    public ResponseEntity<List<TraineeDtoProjection>> getAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "999") int size) {
        Page<Trainee> traineeList = traineeService.all(page, size);
        return new ResponseEntity<>(toTraineeDto.convert(traineeList.getContent()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TraineeDtoProjection> getOne(@PathVariable Long id) {
        Optional<Trainee> trainee = traineeService.one(id);
        return new ResponseEntity<>(toTraineeDto.convert(trainee.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TraineeDtoProjection> save(@RequestBody TraineeRequest request) {
        Trainee saved = traineeService.save(request);
        return new ResponseEntity<>(toTraineeDto.convert(saved), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TraineeDtoProjection> update(
            @PathVariable Long id,
            @RequestBody TraineeRequest request
    ) {
        Trainee persisted = traineeService.update(request, id);
        return new ResponseEntity<>(toTraineeDto.convert(persisted), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        traineeService.delete(id);
        return new ResponseEntity<>("Student deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<TraineeDtoProjection> getTraineesByDsOrName(
            @RequestParam Long drivingSchoolId,
            @RequestParam String traineeName
    ) {
        return traineeService.getTraineesByDsOrName(
                drivingSchoolId,
                traineeName);
    }
}
