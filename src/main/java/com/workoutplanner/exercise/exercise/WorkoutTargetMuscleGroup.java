package com.workoutplanner.exercise.exercise;

public enum WorkoutTargetMuscleGroup {
    UPPERBODY("U"), LOWERBODY("L"), CORE("C"), WHOLEBODY("W");

    private String code;

    private WorkoutTargetMuscleGroup(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
