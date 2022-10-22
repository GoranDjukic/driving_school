package com.gorandjukic.drivingSchool.web.request;

import javax.validation.constraints.Min;
import java.time.LocalDate;

public class ExamRequest {

    @Min(value = 0, message = "The value must be positive")
    private Integer numberOfSeats;
    private LocalDate date;
    private Long drivingSchoolId;

    public ExamRequest() {
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getDrivingSchoolId() {
        return drivingSchoolId;
    }

    public void setDrivingSchoolId(Long drivingSchoolId) {
        this.drivingSchoolId = drivingSchoolId;
    }
}
