package com.workoutplanner.exercise.exercise;


import java.time.LocalDate;

import com.workoutplanner.exercise.user_created_workout.UserCreatedWorkout;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Exercise {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="exercise_id")
private Integer exerciseId;

private String exerciseName;

private String exerciseType;

private Integer defaultSets;

private Integer defaultReps;

private Integer oneRepMax;

private double Weight;

private LocalDate date;

private ExerciseTargetMuscleGroup targetMuscleGroup;

@ManyToOne
@JoinColumn(name="userCreatedWorkout", nullable = false)
private UserCreatedWorkout userCreatedWorkout;


    public Exercise() {
    }


    public Exercise(Integer id, String exerciseName, String exerciseType, Integer defaultSets, Integer defaultReps, Integer oneRepMax, ExerciseTargetMuscleGroup targetMuscleGroup) {
        this.exerciseId = id;
        this.exerciseName = exerciseName;
        this.exerciseType = exerciseType;
        this.defaultSets = defaultSets;
        this.defaultReps = defaultReps;
        this.oneRepMax = oneRepMax;
        this.targetMuscleGroup = targetMuscleGroup;
    }



    public Integer getId() {
        return this.exerciseId;
    }

    public void setId(Integer id) {
        this.exerciseId = id;
    }

    public String getExerciseName() {
        return this.exerciseName;
    }

    public void setExerciseName(String Name) {
        this.exerciseName = Name;
    }

    public String getExerciseType() {
        return this.exerciseType;
    }

    public void setExerciseType(String Type) {
        this.exerciseType = Type;
    }

    public Integer getDefaultSets() {
        return this.defaultSets;
    }

    public void setDefaultSets(Integer defaultSets) {
        this.defaultSets = defaultSets;
    }

    public Integer getDefaultReps() {
        return this.defaultReps;
    }

    public void setDefaultReps(Integer defaultReps) {
        this.defaultReps = defaultReps;
    }

    public Integer getOneRepMax() {
        return this.oneRepMax;
    }

    public void setOneRepMax(Integer oneRepMax) {
        this.oneRepMax = oneRepMax;
    }

    public double getExerciseWeight() {
        return this.Weight;
    }

    public void setExerciseWeight(double Weight) {
        this.Weight = Weight;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ExerciseTargetMuscleGroup getTargetMuscleGroup() {
        return this.targetMuscleGroup;
    }

    public void setExerciseTargetMuscleGroup(ExerciseTargetMuscleGroup target) {
        targetMuscleGroup = target;
    }


}
