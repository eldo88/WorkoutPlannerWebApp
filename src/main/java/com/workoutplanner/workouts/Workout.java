package com.workoutplanner.workouts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workout {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

private String workoutName;

private String workoutType;

private Integer defaultSets;

private Integer defaultReps;

private WorkoutTargetMuscleGroup targetMuscleGroup;


    public Workout() {
    }


    public Workout(Integer id, String workoutName, String workoutType, Integer defaultSets, Integer defaultReps, WorkoutTargetMuscleGroup targetMuscleGroup) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutType = workoutType;
        this.defaultSets = defaultSets;
        this.defaultReps = defaultReps;
        this.targetMuscleGroup = targetMuscleGroup;
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutType() {
        return this.workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
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

    public WorkoutTargetMuscleGroup getTargetMuscleGroup() {
        return this.targetMuscleGroup;
    }

    public void setTargetMuscleGroup(WorkoutTargetMuscleGroup target) {
        targetMuscleGroup = target;
    }

}
