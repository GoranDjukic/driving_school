package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.web.dto.TraineeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TraineeDtoToTrainee implements Converter<TraineeDto, Trainee> {

    @Autowired
    private TraineeService traineeService;

    @Override
    public Trainee convert(TraineeDto source) {
        // naredni kod nije sa sigurnoscu radjen
        Trainee trainee = null;
        if (source.getId() != null) {
            trainee = traineeService.one(source.getId()).get();
        }
        if (trainee == null) {
            trainee = new Trainee();
        }
        trainee.setId(source.getId());
        trainee.setName(source.getName());
        trainee.setSurname(source.getSurname());
        trainee.setBirthYear(source.getBirthYear());
        trainee.setPlace(source.getPlace());

        return trainee;
    }
}
