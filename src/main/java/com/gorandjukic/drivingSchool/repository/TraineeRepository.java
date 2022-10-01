package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.model.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {
}
