package com.gorandjukic.drivingSchool.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DrivingSchool extends BaseEntity {

    private String name;
    private Integer yearOfEst;
    private Integer numberOfVehicles;

    @OneToMany(mappedBy = "drivingSchool", cascade = CascadeType.ALL)
    private List<Trainee> trainees = new ArrayList<>();

    @OneToMany(mappedBy = "drivingSchool", cascade = CascadeType.ALL)
    private List<Exam> exams = new ArrayList<>();

    // todo read about static factory pattern
//     Example:
//    public static DrivingSchool initialized(
//            String name,
//            Integer yearOfEst,
//            Integer numberOfVehicle
//    ) {
//        return new DrivingSchool(
//                name,
//                yearOfEst,
//                numberOfVehicle,
//                new ArrayList<>(),
//                new ArrayList<>()
//        );
//    }

    public DrivingSchool() {
    }

    public DrivingSchool(String name, Integer yearOfEst, Integer numberOfVehicle,
                         List<Trainee> trainees, List<Exam> exams) {
        this.name = name;
        this.yearOfEst = yearOfEst;
        this.numberOfVehicles = numberOfVehicle;
        this.trainees = trainees;
        this.exams = exams;
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

    public Integer getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(Integer numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
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
        return Objects.equals(getId(), that.getId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getYearOfEst(), that.getYearOfEst()) && Objects.equals(getNumberOfVehicles(), that.getNumberOfVehicles()) && Objects.equals(getTrainees(), that.getTrainees()) && Objects.equals(getExams(), that.getExams());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getYearOfEst(), getNumberOfVehicles());
    }

    @Override
    public String toString() {
        return "DrivingSchool{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfEst=" + yearOfEst +
                ", numberOfVehicle=" + numberOfVehicles +
                '}';
    }
}
