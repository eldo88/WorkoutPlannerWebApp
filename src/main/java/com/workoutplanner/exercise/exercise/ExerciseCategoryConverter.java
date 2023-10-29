package com.workoutplanner.exercise.exercise;

import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ExerciseCategoryConverter implements AttributeConverter<ExerciseTargetMuscleGroup, String> {

    @Override
    public String convertToDatabaseColumn(ExerciseTargetMuscleGroup targetMuscleGroup) {
        if (targetMuscleGroup == null) {
            return null;
        }
        return targetMuscleGroup.getCode();
    }

    @Override
    public ExerciseTargetMuscleGroup convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(ExerciseTargetMuscleGroup.values())
        .filter(c-> c.getCode().equals(code))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
    }
    
}
