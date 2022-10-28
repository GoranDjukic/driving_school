package com.gorandjukic.drivingSchool.service.impl;

import com.gorandjukic.drivingSchool.domain.Exam;
import com.gorandjukic.drivingSchool.domain.Examination;
import com.gorandjukic.drivingSchool.domain.Trainee;
import com.gorandjukic.drivingSchool.domain.exception.GenericBadRequestException;
import com.gorandjukic.drivingSchool.domain.exception.GenericNotFoundException;
import com.gorandjukic.drivingSchool.repository.ExamRepository;
import com.gorandjukic.drivingSchool.repository.ExaminationRepository;
import com.gorandjukic.drivingSchool.repository.TraineeRepository;
import com.gorandjukic.drivingSchool.service.ExaminationService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    private final ExaminationRepository examinationRepository;
    private final TraineeRepository traineeRepository;
    private final ExamRepository examRepository;

    public ExaminationServiceImpl(
            ExaminationRepository examinationRepository,
            TraineeRepository traineeRepository,
            ExamRepository examRepository
    ) {
        this.examinationRepository = examinationRepository;
        this.traineeRepository = traineeRepository;
        this.examRepository = examRepository;
    }

    @Transactional
    @Override
    public Examination apply(Long traineeId, Long examId) {
        Exam exam = getExamOrElseThrow(examId);
        Trainee trainee = getTraineeOrElseThrow(traineeId);

        validateExaminationRequest(trainee, exam);

        Exam updatedExam = exam.addTrainee();
        examRepository.save(updatedExam);

        Examination examination = Examination.initiated(updatedExam, trainee);

        return examinationRepository.save(examination);
    }

    private void validateExaminationRequest(Trainee trainee, Exam exam) {
        if (exam.getNumberOfSeats() < 1) {
            throw new GenericBadRequestException("Dati ispit nema vise slobodnih mesta!");
        }
        if (!exam.getDrivingSchool().equals(trainee.getDrivingSchool())) {
            throw new GenericBadRequestException("Mozete aplicirati samo za ispite vase auto skole!");
        }
        if (trainee.hasPendingExaminations()) {
            throw new GenericBadRequestException("Ne mozete aplicirati na jos predavanja dok ne kompletirate trenutna!");
        }
    }

    private Exam getExamOrElseThrow(Long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new GenericNotFoundException("Exam not found!"));
    }

    private Trainee getTraineeOrElseThrow(Long traineeId) {
        return traineeRepository.findByIdInitialized(traineeId)
                .orElseThrow(() -> new GenericNotFoundException("Trainee not found!"));
    }

    @Override
    public void complete(Long examId, boolean result) {

    }

}
