package com.gorandjukic.drivingSchool.repository;

import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.web.response.TraineeDtoProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

    @Query("SELECT new com.gorandjukic.drivingSchool.web.response.TraineeDtoProjection(" +
            "t.name, t.surname, t.birthYear, t.place, ds.name" +
            ") " +
            "FROM Trainee t LEFT JOIN t.drivingSchool ds " +
            "WHERE ds.id = :drivingSchoolId " +
            "AND t.name = :traineeName")
    List<TraineeDtoProjection> getTraineesByDsOrName(
            @Param("drivingSchoolId") Long drivingSchoolId,
            @Param("traineeName") String traineeName
    );

    @Query("SELECT t FROM Trainee t LEFT JOIN FETCH t.examinations e WHERE t.id = :id ")
    Optional<Trainee> findByIdInitialized(@Param("id") Long id);

}
