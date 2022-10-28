package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.repository.TraineeRepository;
import com.gorandjukic.drivingSchool.service.TraineeService;
import com.gorandjukic.drivingSchool.support.TraineeEntityMapper;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import com.gorandjukic.drivingSchool.web.response.TraineeDtoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    private final TraineeRepository traineeRepository;
    private final TraineeEntityMapper traineeEntityMapper;

    public TraineeServiceImpl(
            TraineeRepository traineeRepository,
            TraineeEntityMapper traineeEntityMapper
    ) {
        this.traineeRepository = traineeRepository;
        this.traineeEntityMapper = traineeEntityMapper;
    }

    // todo naziv funkcije treba da bude izrazen kao glagol
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
        Trainee trainee = traineeEntityMapper.convert(traineeDto);
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
        // todo check if exist
        traineeRepository.deleteById(id);
        return null; // todo void
    }

    @Override
    public List<TraineeDtoProjection> getTraineesByDsOrName(Long drivingSchoolId, String traineeName) {
        return traineeRepository.getTraineesByDsOrName(drivingSchoolId, traineeName);
    }
}
