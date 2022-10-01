package com.gorandjukic.drivingSchool.web.dto;

import org.hibernate.validator.constraints.Length;

public class TraineeDto {

    private Long id;

    @Length(max = 30)
    private String name;

    private String surname;

    private Integer birthYear;

    private String place;

    private boolean listenedTheory = true;

    private boolean drivingDone = true;

    private boolean passedExam = true;

    private Long drivingSchoolId;
    private String drivingSchoolName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isListenedTheory() {
        return listenedTheory;
    }

    public void setListenedTheory(boolean listenedTheory) {
        this.listenedTheory = listenedTheory;
    }

    public boolean isDrivingDone() {
        return drivingDone;
    }

    public void setDrivingDone(boolean drivingDone) {
        this.drivingDone = drivingDone;
    }

    public boolean isPassedExam() {
        return passedExam;
    }

    public void setPassedExam(boolean passedExam) {
        this.passedExam = passedExam;
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
