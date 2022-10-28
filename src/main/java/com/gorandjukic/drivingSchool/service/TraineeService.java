package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.web.request.TraineeRequest;
import com.gorandjukic.drivingSchool.web.response.TraineeResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface TraineeService {
    // todo use pageable
    Page<Trainee> all(int page, int size);

    Optional<Trainee> one(Long id);

    Trainee save(TraineeRequest request);

    Trainee update(TraineeRequest request, Long id);

    Trainee delete(Long id);

    List<TraineeResponse> getTraineesByDsOrName(Long drivingSchoolId, String traineeName);
}
