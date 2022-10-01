package com.gorandjukic.drivingSchool.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer numberOfSeats;

    @Column(name = "date_of_exam", nullable = false)
    private LocalDate date;

    @ManyToOne
    private DrivingSchool drivingSchool;

    public Exam() {
    }

    public Exam(Integer numberOfSeats, LocalDate date, DrivingSchool drivingSchool) {
        this.numberOfSeats = numberOfSeats;
        this.date = date;
        this.drivingSchool = drivingSchool;
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
