package com.gorandjukic.drivingSchool.support;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.repository.DrivingSchoolRepository;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TraineeEntityMapper implements Converter<TraineeRequest, Trainee> {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Override
    public Trainee convert(TraineeRequest source) {

        Trainee trainee = new Trainee();

        trainee.setName(source.getName());
        trainee.setSurname(source.getSurname());
        trainee.setBirthYear(source.getBirthYear());
        trainee.setPlace(source.getPlace());

        DrivingSchool drivingSchool = drivingSchoolRepository.getReferenceById(source.getDrivingSchoolId());
        trainee.setDrivingSchool(drivingSchool);

        return trainee;
    }
}
