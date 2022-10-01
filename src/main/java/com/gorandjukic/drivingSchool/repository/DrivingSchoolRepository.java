package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Long> {
}
