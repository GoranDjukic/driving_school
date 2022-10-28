package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.web.response.DrivingSchoolResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrivingSchoolResponseMapper implements Converter<DrivingSchool, DrivingSchoolResponse> {

    @Override
    public DrivingSchoolResponse convert(DrivingSchool source) {
        DrivingSchoolResponse dto = new DrivingSchoolResponse();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setNumberOfVehicle(source.getNumberOfVehicles());
        dto.setYearOfEst(source.getYearOfEst());

        return dto;
    }

    public List<DrivingSchoolResponse> convert(List<DrivingSchool> source) {
        List<DrivingSchoolResponse> dtos = new ArrayList<>();

        for (DrivingSchool ds : source) {
            DrivingSchoolResponse dto = convert(ds);
            dtos.add(dto);
        }
        return dtos;
    }

}
