package com.gorandjukic.drivingSchool.web.request;

import javax.validation.constraints.NotNull;

public class ExaminationRequest {

    @NotNull(message = "Trainee id is mandatory")
    private Long traineeId;
    @NotNull(message = "Exam id is mandatory")
    private Long examId;

    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

}
