package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.Exam;
import com.gorandjukic.drivingSchool.web.dto.ExamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamToExamDto implements Converter<Exam, ExamDto> {


    @Override
    public ExamDto convert(Exam source) {
        ExamDto dto = new ExamDto();

        dto.setId(source.getId());
        dto.setNumberOfSeats(source.getNumberOfSeats());
        dto.setDate(source.getDate());

        dto.setDrivingSchoolId(source.getDrivingSchool().getId());
        dto.setDrivingSchoolName(source.getDrivingSchool().getName());

        return dto;
    }

    public List<ExamDto> convert (List<Exam> source) {
        List<ExamDto> dtos = new ArrayList<>();

        for (Exam e : source) {
            dtos.add(convert(e));
        }
        return dtos;
    }
}
