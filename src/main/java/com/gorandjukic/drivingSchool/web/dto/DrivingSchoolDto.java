package com.gorandjukic.drivingSchool.web.dto;

import org.hibernate.validator.constraints.Length;

public class DrivingSchoolDto {

    private Long id;

    @Length(max = 50)
    private String name;

    private Integer yearOfEst;

    private Integer numberOfVehicle;

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


}
