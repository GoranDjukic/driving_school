package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.domain.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}
