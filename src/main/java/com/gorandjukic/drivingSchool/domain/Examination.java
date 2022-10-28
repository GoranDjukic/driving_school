package com.gorandjukic.drivingSchool.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Examination extends BaseEntity {

    @JoinColumn(name = "exam_id")
    @ManyToOne
    private Exam exam;
    @JoinColumn(name = "trainee_id")
    @ManyToOne
    private Trainee trainee;
    @Enumerated(EnumType.STRING)
    private ExaminationState state;

    public static Examination initiated(
            Exam exam,
            Trainee trainee
    ) {
        return new Examination(
                exam,
                trainee,
                ExaminationState.PENDING
        );
    }

    public Examination() {
    }

    public Examination(Exam exam, Trainee trainee, ExaminationState state) {
        this.exam = exam;
        this.trainee = trainee;
        this.state = state;
    }

    public boolean isPending() {
        return ExaminationState.PENDING.equals(this.state);
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public ExaminationState getState() {
        return state;
    }

    public void setState(ExaminationState state) {
        this.state = state;
    }

}
