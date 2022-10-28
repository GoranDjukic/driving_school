package com.gorandjukic.drivingSchool.web.response;

public class TraineeDtoProjection {

    private Long id;
    private String name;
    private String surname;
    private Integer birthYear;
    private String place;
    private boolean listenedTheory;
    private boolean drivingDone;
    private Long drivingSchoolId;
    private String drivingSchoolName;
    private boolean appliedExam;


    public TraineeDtoProjection() {
    }

    public TraineeDtoProjection(
            Long id,
            String name,
            String surname,
            Integer birthYear,
            String place,
            Long drivingSchoolId,
            String drivingSchoolName,
            boolean appliedExam
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.place = place;
        this.drivingSchoolId = drivingSchoolId;
        this.drivingSchoolName = drivingSchoolName;
        this.appliedExam = appliedExam;
    }

    public TraineeDtoProjection(
            String name,
            String surname,
            Integer birthYear,
            String place,
            String drivingSchoolName
    ) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.place = place;
        this.drivingSchoolName = drivingSchoolName;
    }

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

    public boolean isAppliedExam() {
        return appliedExam;
    }

    public void setAppliedExam(boolean appliedExam) {
        this.appliedExam = appliedExam;
    }
}
