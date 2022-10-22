package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.domain.DrivingSchool;
import com.gorandjukic.drivingSchool.web.response.ExamResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Long> {

    @Query("SELECT new com.gorandjukic.drivingSchool.web.response.ExamResponse(" +
            "ex.id, ex.numberOfSeats, ex.date, ds.id, ds.name" +
            ") " +
            "FROM Exam ex LEFT JOIN ex.drivingSchool ds " +
            "WHERE ds.id = :drivingSchoolId")
    List<ExamResponse> getExamsByDrivingSchoolId(

            @Param("drivingSchoolId") Long drivingSchoolId);
}
