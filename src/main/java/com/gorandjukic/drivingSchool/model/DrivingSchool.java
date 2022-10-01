package com.gorandjukic.drivingSchool.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "driving_school")
public class DrivingSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer yearOfEst;

    @Column
    private Integer numberOfVehicle;

    @OneToMany(mappedBy = "driving_school", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();

    @OneToMany(mappedBy = "driving_school", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Exam> exams = new ArrayList<>();

    public DrivingSchool() {
    }

    public DrivingSchool(String name, Integer yearOfEst, Integer numberOfVehicle,
                         List<Trainee> trainees, List<Exam> exams) {
        this.name = name;
        this.yearOfEst = yearOfEst;
        this.numberOfVehicle = numberOfVehicle;
        this.trainees = trainees;
        this.exams = exams;
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

    public Integer getYearOfEst() {
        return yearOfEst;
    }

    public void setYearOfEst(Integer yearOfEst) {
        this.yearOfEst = yearOfEst;
    }

    public Integer getNumberOfVehicle() {
        return numberOfVehicle;
    }

    public void setNumberOfVehicle(Integer numberOfVehicle) {
        this.numberOfVehicle = numberOfVehicle;
    }

    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof DrivingSchool))
            return false;
        DrivingSchool that = (DrivingSchool) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getYearOfEst(), that.getYearOfEst()) && Objects.equals(getNumberOfVehicle(), that.getNumberOfVehicle()) && Objects.equals(getTrainees(), that.getTrainees()) && Objects.equals(getExams(), that.getExams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getYearOfEst(), getNumberOfVehicle(), getTrainees(), getExams());
    }

    @Override
    public String toString() {
        return "DrivingSchool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfEst=" + yearOfEst +
                ", numberOfVehicle=" + numberOfVehicle +
                ", trainees=" + trainees +
                ", exams=" + exams +
                '}';
    }
}
