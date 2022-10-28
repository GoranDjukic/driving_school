package com.gorandjukic.drivingSchool.service;

import com.gorandjukic.drivingSchool.domain.Examination;

public interface ExaminationService {

    Examination apply(Long traineeId, Long examId);

    void complete(Long examId, boolean result);

}
