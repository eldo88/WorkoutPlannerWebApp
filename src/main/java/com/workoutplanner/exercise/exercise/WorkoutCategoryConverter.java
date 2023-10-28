package com.workoutplanner.exercise.exercise;

import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class WorkoutCategoryConverter implements AttributeConverter<WorkoutTargetMuscleGroup, String> {

    @Override
    public String convertToDatabaseColumn(WorkoutTargetMuscleGroup targetMuscleGroup) {
        if (targetMuscleGroup == null) {
            return null;
        }
        return targetMuscleGroup.getCode();
    }

    @Override
    public WorkoutTargetMuscleGroup convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(WorkoutTargetMuscleGroup.values())
        .filter(c-> c.getCode().equals(code))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
    }
    
}
