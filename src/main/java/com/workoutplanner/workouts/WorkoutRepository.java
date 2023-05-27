package com.workoutplanner.workouts;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import org.springframework.data.repository.query.Param;

public interface WorkoutRepository extends CrudRepository<Workout, Integer> {

    List<Workout> findByWorkoutName(@Param("workoutName") String workoutName);

    List<Workout> findByWorkoutType(@Param("workoutType") String workoutType);

}
