package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.model.Trainee;
import com.gorandjukic.drivingSchool.web.dto.TraineeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraineeToTraineeDto implements Converter<Trainee, TraineeDto> {

    @Override
    public TraineeDto convert(Trainee source) {
        TraineeDto dto = new TraineeDto();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setSurname(source.getSurname());
        dto.setBirthYear(source.getBirthYear());
        dto.setPlace(source.getPlace());
        dto.setListenedTheory(source.isListenedTheory());
        dto.setDrivingDone(source.isDrivingDone());
        dto.setPassedExam(source.isPassedExam());

        dto.setDrivingSchoolId(source.getDrivingSchool().getId());
        dto.setDrivingSchoolName(source.getDrivingSchool().getName());

        return dto;
    }

    public List<TraineeDto> convert (List<Trainee> source) {
        List<TraineeDto> dtos = new ArrayList<>();

        for (Trainee t : source) {
            dtos.add(convert(t));
        }
        return dtos;
    }
}
