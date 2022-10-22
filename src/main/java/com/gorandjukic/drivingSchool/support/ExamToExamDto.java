package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.Exam;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamToExamDto implements Converter<Exam, ExamResponse> {


    @Override
    public ExamResponse convert(Exam source) {
        ExamResponse dto = new ExamResponse();

        dto.setId(source.getId());
        dto.setNumberOfSeats(source.getNumberOfSeats());
        dto.setDate(source.getDate());

        dto.setDrivingSchoolId(source.getDrivingSchool().getId());
        dto.setDrivingSchoolName(source.getDrivingSchool().getName());

        return dto;
    }

    public List<ExamResponse> convert(List<Exam> source) {
        List<ExamResponse> dtos = new ArrayList<>();

        for (Exam e : source) {
            dtos.add(convert(e));
        }
        return dtos;
    }
}
