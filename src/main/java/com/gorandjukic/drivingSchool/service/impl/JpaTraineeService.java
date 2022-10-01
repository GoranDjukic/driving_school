package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.repository.TraineeRepository;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.web.dto.TraineeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaTraineeService implements TraineeService {

    @Autowired
    private TraineeRepository traineeRepository;

    @Override
    public Page<Trainee> all(int page) {
        return traineeRepository.findAll(PageRequest.of(page, 2));
    }

    @Override
    public Optional<Trainee> one(Long id) {
        return traineeRepository.findById(id);
    }

    // potrebno implementirati
    @Override
    public Trainee save(TraineeDto trainee) {
        return null;
    }

    // potrebno implementirati
    @Override
    public Trainee update(Trainee trainee) {
        return null;
    }

    // potrebno implementirati
    @Override
    public Trainee delete(Long id) {
        return null;
    }
}
