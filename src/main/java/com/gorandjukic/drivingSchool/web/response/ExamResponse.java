package com.gorandjukic.drivingSchool.web.response;

import java.time.LocalDate;

// DTO projection - useful reference Thorben Jansen Hibernate Tips
public class ExamResponse {

    private Long id;
    private Integer numberOfSeats;
    private LocalDate date;
    private Long drivingSchoolId;
    private String drivingSchoolName;

    public ExamResponse() {
    }

    public ExamResponse(
            Long id,
            Integer numberOfSeats,
            LocalDate date,
            Long drivingSchoolId,
            String drivingSchoolName
    ) {
        this.id = id;
        this.numberOfSeats = numberOfSeats;
        this.date = date;
        this.drivingSchoolId = drivingSchoolId;
        this.drivingSchoolName = drivingSchoolName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDrivingSchoolName() {
        return drivingSchoolName;
    }

    public void setDrivingSchoolName(String drivingSchoolName) {
        this.drivingSchoolName = drivingSchoolName;
    }
}
