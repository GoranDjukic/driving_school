package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.web.response.TraineeResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TraineeToTraineeDto implements Converter<Trainee, TraineeResponse> {

    @Override
    public TraineeResponse convert(Trainee source) {
        TraineeResponse dto = new TraineeResponse();

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

    public List<TraineeResponse> convert (List<Trainee> source) {
        List<TraineeResponse> dtos = new ArrayList<>();

        for (Trainee t : source) {
            dtos.add(convert(t));
        }
        return dtos;
    }
}
