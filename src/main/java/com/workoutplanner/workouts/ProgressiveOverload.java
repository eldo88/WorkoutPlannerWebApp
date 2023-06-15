package com.workoutplanner.workouts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="progressive_overload")
public class ProgressiveOverload {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private double percentageOfOneRepMax;

    private int reps;

    private String trainingType;



    public ProgressiveOverload() {
    }
   


    public ProgressiveOverload(Integer id, double percentageOfOneRepMax, int reps, String trainingType) {
        this.id = id;
        this.percentageOfOneRepMax = percentageOfOneRepMax;
        this.reps = reps;
        this.trainingType = trainingType;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPercentageOfOneRepMax() {
        return this.percentageOfOneRepMax;
    }


    public int getReps() {
        return this.reps;
    }


    public String getTrainingType() {
        return this.trainingType;
    }

}