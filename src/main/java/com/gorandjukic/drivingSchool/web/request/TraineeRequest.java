package com.gorandjukic.drivingSchool.web.request;

import org.hibernate.validator.constraints.Length;

public class TraineeRequest {

    @Length(max = 30)
    private String name;
    private String surname;
    private Integer birthYear;
    private String place;
    private Long drivingSchoolId;

    public TraineeRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Long getDrivingSchoolId() {
        return drivingSchoolId;
    }

    public void setDrivingSchoolId(Long drivingSchoolId) {
        this.drivingSchoolId = drivingSchoolId;
    }

}
