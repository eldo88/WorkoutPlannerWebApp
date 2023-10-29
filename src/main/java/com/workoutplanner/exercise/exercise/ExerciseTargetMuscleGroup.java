package com.workoutplanner.exercise.exercise;

public enum ExerciseTargetMuscleGroup {
    UPPERBODY("U"), LOWERBODY("L"), CORE("C"), WHOLEBODY("W");

    private String code;

    private ExerciseTargetMuscleGroup(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
