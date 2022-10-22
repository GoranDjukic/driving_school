package com.gorandjukic.drivingSchool.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Exam extends BaseEntity {

    private Integer numberOfSeats;
    private LocalDate date;
    @ManyToOne
    private DrivingSchool drivingSchool;

    public Exam() {
    }

    public Exam(
            Integer numberOfSeats,
            LocalDate date,
            DrivingSchool drivingSchool
    ) {
        this.numberOfSeats = numberOfSeats;
        this.date = date;
        this.drivingSchool = drivingSchool;
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
        if (!(o instanceof Exam))
            return false;
        Exam exam = (Exam) o;
        return Objects.equals(getId(), exam.getId()) && Objects.equals(getNumberOfSeats(), exam.getNumberOfSeats()) && Objects.equals(getDate(), exam.getDate()) && Objects.equals(getDrivingSchool(), exam.getDrivingSchool());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNumberOfSeats(), getDate(), getDrivingSchool());
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", numberOfSeats=" + numberOfSeats +
                ", date=" + date +
                ", drivingSchool=" + drivingSchool +
                '}';
    }
}
