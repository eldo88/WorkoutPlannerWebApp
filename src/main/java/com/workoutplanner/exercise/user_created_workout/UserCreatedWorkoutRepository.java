package com.workoutplanner.exercise.user_created_workout;

import org.springframework.data.repository.CrudRepository;

public interface UserCreatedWorkoutRepository extends CrudRepository<UserCreatedWorkout, Integer> {
    
}
