package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.repository.TraineeRepository;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.support.TraineeDtoToTrainee;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import com.gorandjukic.drivingSchool.web.response.TraineeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {


    @Autowired
    private TraineeRepository traineeRepository;

    @Autowired
    private TraineeDtoToTrainee ToTrainee;

    @Override
    public Page<Trainee> all(int page, int size) {
        return traineeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public Optional<Trainee> one(Long id) {
        return traineeRepository.findById(id);
    }

    @Override
    public Trainee save(TraineeRequest traineeDto) {
        Trainee trainee = ToTrainee.convert(traineeDto);
        return traineeRepository.save(trainee);
    }

    @Override
    public Trainee update(TraineeRequest request, Long id) {
        Optional<Trainee> existingTrainee = traineeRepository.findById(id);
        Trainee newTrainee = existingTrainee.get();

        newTrainee.setName(request.getName());
        newTrainee.setSurname(request.getSurname());
        newTrainee.setBirthYear(request.getBirthYear());
        newTrainee.setPlace(request.getPlace());

        return traineeRepository.save(newTrainee);
    }

    @Override
    public Trainee delete(Long id) {
        traineeRepository.deleteById(id);
        return null;
    }

    @Override
    public List<TraineeResponse> getTraineesByDsOrName(
            Long drivingSchoolId,
            String traineeName
    ) {
        return traineeRepository.getTraineesByDsOrName(drivingSchoolId, traineeName);
    }


}
