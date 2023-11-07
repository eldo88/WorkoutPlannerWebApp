package com.workoutplanner.exercise.user_created_workout;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.workoutplanner.exercise.exercise.Exercise;
import com.workoutplanner.exercise.exercise.ExerciseService;
import com.workoutplanner.exercise.user.User;

@Service
public class UserCreatedWorkoutService {

    @Autowired 
    UserCreatedWorkoutRepository userCreatedWorkoutRepository;

    @Autowired
    ExerciseService exerciseService;


    public void createWorkout(Integer userId, String workoutName, List<Integer> exerciseIds) {
        User user = new User();

        user.setId(userId);
        UserCreatedWorkout userCreatedWorkout = new UserCreatedWorkout(user, exerciseIds, workoutName);

        userCreatedWorkoutRepository.save(userCreatedWorkout);
    }

    public Iterable<UserCreatedWorkout> getUserWorkouts(Integer userId) {

        List<UserCreatedWorkout> userWorkouts = new ArrayList<>();

        return userWorkouts;
    }
    
}
