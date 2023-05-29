package com.workoutplanner.workouts;

public enum WorkoutTargetMuscleGroup {
    UPPERBODY("U"), LOWERBODY("U"), CORE("C"), WHOLEBODY("W");

    private String code;

    private WorkoutTargetMuscleGroup(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
