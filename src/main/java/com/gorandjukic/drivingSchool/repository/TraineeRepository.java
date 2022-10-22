package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.web.response.TraineeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    @Query("SELECT new com.gorandjukic.drivingSchool.web.response.TraineeResponse(" +
            "t.name, t.surname, t.birthYear, t.place, ds.name, t.passedExam" +
            ") " +
            "FROM Trainee t LEFT JOIN t.drivingSchool ds " +
            "WHERE ds.id = :drivingSchoolId " +
            "AND t.name = :traineeName")
    List<TraineeResponse> getTraineesByDsOrName (
            @Param("drivingSchoolId") Long drivingSchoolId, @Param("traineeName") String traineeName);
}
