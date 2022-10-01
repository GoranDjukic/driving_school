package com.gorandjukic.drivingSchool.repository;


import com.gorandjukic.drivingSchool.domain.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    // treba proveriti
    @Query("SELECT e FROM Exam e WHERE " +
            "(:drivingSchoolId IS NULL OR e.drivingSchool.id = :drivingSchoolId)")
    Page<Exam> search(@Param("drivingSchoolId") Long id, Pageable pageable);

}
