package com.gorandjukic.drivingSchool.domain;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trainee extends BaseEntity {

    private String name;
    private String surname;
    private Integer birthYear;
    private String place;
    private boolean listenedTheory;
    private boolean drivingDone;
    @JoinColumn(name = "driving_school_id")
    @ManyToOne
    private DrivingSchool drivingSchool;
    @OneToMany(mappedBy = "exam")
    private Set<Examination> examinations = new HashSet<>();

    public Trainee() {
    }

    public Trainee(
            String name,
            String surname,
            Integer birthYear,
            String place,
            boolean listenedTheory,
            boolean drivingDone,
            DrivingSchool drivingSchool
    ) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.place = place;
        this.listenedTheory = listenedTheory;
        this.drivingDone = drivingDone;
        this.drivingSchool = drivingSchool;
    }

    public boolean hasPendingExaminations() {
        return this.examinations.stream().anyMatch(Examination::isPending);
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

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

}
