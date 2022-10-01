package com.gorandjukic.drivingSchool.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private Integer birthYear;

    @Column
    private String place;

    @Column
    private boolean listenedTheory = false;

    @Column
    private boolean drivingDone = false;

    @Column
    private boolean passedExam = false;

    @ManyToOne
    private DrivingSchool drivingSchool;

    public Trainee() {
    }

    public Trainee(String name, String surname, Integer birthYear, String place,
                   boolean listenedTheory, boolean drivingDone, boolean passedExam, DrivingSchool drivingSchool) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.place = place;
        this.listenedTheory = listenedTheory;
        this.drivingDone = drivingDone;
        this.passedExam = passedExam;
        this.drivingSchool = drivingSchool;
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

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Trainee))
            return false;
        Trainee trainee = (Trainee) o;
        return isListenedTheory() == trainee.isListenedTheory() && isDrivingDone() == trainee.isDrivingDone() && isPassedExam() == trainee.isPassedExam() && Objects.equals(getId(), trainee.getId()) && Objects.equals(getName(), trainee.getName()) && Objects.equals(getSurname(), trainee.getSurname()) && Objects.equals(getBirthYear(), trainee.getBirthYear()) && Objects.equals(getPlace(), trainee.getPlace()) && Objects.equals(getDrivingSchool(), trainee.getDrivingSchool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getBirthYear(), getPlace(), isListenedTheory(), isDrivingDone(), isPassedExam(), getDrivingSchool());
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthYear=" + birthYear +
                ", place='" + place + '\'' +
                ", listenedTheory=" + listenedTheory +
                ", drivingDone=" + drivingDone +
                ", passedExam=" + passedExam +
                ", drivingSchool=" + drivingSchool +
                '}';
    }
}
