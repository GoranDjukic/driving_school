package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.model.Trainee;
import com.gorandjukic.drivingSchool.web.dto.TraineeDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TraineeService {
    Page<Trainee> all(int page);

    Optional<Trainee> one(Long id);

    // nije implementirano
    Trainee save(TraineeDto trainee);

    // nije implementirano
    Trainee update(Trainee trainee);

    // nije implementirano
    Trainee delete(Long id);
}
