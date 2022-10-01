package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.model.DrivingSchool;
import com.gorandjukic.drivingSchool.web.dto.DrivingSchoolDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DrivingSchoolToDrivingSchoolDto implements Converter<DrivingSchool, DrivingSchoolDto> {

    @Override
    public DrivingSchoolDto convert(DrivingSchool source) {
        DrivingSchoolDto dto = new DrivingSchoolDto();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setNumberOfVehicle(source.getNumberOfVehicle());
        dto.setYearOfEst(source.getYearOfEst());

        return dto;
    }

    public List<DrivingSchoolDto> convert(List<DrivingSchool> source) {
        List<DrivingSchoolDto> dtos = new ArrayList<>();

        for (DrivingSchool ds : source) {
            DrivingSchoolDto dto = convert(ds);
            dtos.add(dto);
        }
        return dtos;
    }
}
