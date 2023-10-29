package com.workoutplanner.exercise.exercise;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {

    List<Exercise> findByExerciseName(@Param("exerciseName") String exerciseName);

    List<Exercise> findByExerciseType(@Param("exerciseType") String exerciseType);

    List<Exercise> findByTargetMuscleGroup(ExerciseTargetMuscleGroup targetMuscleGroup);

    void deleteById(Integer id);

    @Override
    List<Exercise> findAll();

}
