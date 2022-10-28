package com.gorandjukic.drivingSchool.web.controller;

import com.gorandjukic.drivingSchool.domain.Examination;
import com.gorandjukic.drivingSchool.service.ExaminationService;
import com.gorandjukic.drivingSchool.web.request.ExaminationRequest;
import com.gorandjukic.drivingSchool.web.response.ExaminationResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/examination")
@Validated
public class ExaminationController {

    private final ExaminationService examinationService;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping
    public ExaminationResponse apply(@RequestBody @Valid ExaminationRequest request) {
        Examination examination = examinationService.apply(
                request.getTraineeId(),
                request.getExamId()
        );

        return new ExaminationResponse(examination);
    }

}
