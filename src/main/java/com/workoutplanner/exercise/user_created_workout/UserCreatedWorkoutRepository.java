package com.workoutplanner.exercise.user_created_workout;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.workoutplanner.exercise.user.User;


public interface UserCreatedWorkoutRepository extends CrudRepository<UserCreatedWorkout, Integer> {
    Integer findWorkoutIdByUserIdAndWorkoutName(Integer userId, String workoutName);

    List<UserCreatedWorkout> findByUser(User user);
}
