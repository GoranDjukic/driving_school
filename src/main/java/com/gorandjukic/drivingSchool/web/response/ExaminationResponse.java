package com.gorandjukic.drivingSchool.web.response;

import com.gorandjukic.drivingSchool.domain.Examination;

public class ExaminationResponse {

    private final Examination examination;

    public ExaminationResponse(Examination examination) {
        this.examination = examination;
    }

    public Long getId() {
        return this.examination.getId();
    }

    public String getTraineeName() {
        return this.examination.getTrainee().getName();
    }

    public Long getExamId() {
        return this.examination.getExam().getId();
    }

}
