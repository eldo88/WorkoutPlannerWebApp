package com.workoutplanner.exercise.user_created_workout;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.workoutplanner.exercise.exercise.Exercise;
import com.workoutplanner.exercise.exercise.ExerciseService;
import com.workoutplanner.exercise.user.User;
import com.workoutplanner.exercise.user.UserService;

@Service
public class UserCreatedWorkoutService {

    @Autowired 
    UserCreatedWorkoutRepository userCreatedWorkoutRepository;

    @Autowired
    ExerciseService exerciseService; // maybe not needed

    @Autowired
    UserService userService;


    public void createWorkout(Integer userId, String workoutName, List<Integer> exerciseIds) {
        User user = userService.findById(userId);
        LocalDate date = LocalDate.now();
        UserCreatedWorkout userCreatedWorkout = new UserCreatedWorkout(user, exerciseIds, workoutName);
        //Add date to UCW constructor
        userCreatedWorkout.setCreatedDate(date);
        userCreatedWorkoutRepository.save(userCreatedWorkout);
    }

    public UserCreatedWorkout createdWorkout(UserCreatedWorkout userCreatedWorkout) {
        
        User userWhoCreated = userCreatedWorkout.getUser();
        Integer userId = userWhoCreated.getId();
        User user = userService.findById(userId);

        List<Integer> exerciseIds = userCreatedWorkout.getExerciseIds();

        String workoutName = userCreatedWorkout.getWorkoutName();

        UserCreatedWorkout createdWorkout = new UserCreatedWorkout(user, exerciseIds, workoutName);

        return userCreatedWorkoutRepository.save(createdWorkout);
    }

    public Iterable<UserCreatedWorkout> getUserWorkouts(Integer userId) {
        User user = userService.findById(userId);
        List<UserCreatedWorkout>userWorkouts = userCreatedWorkoutRepository.findByUser(user);
        return userWorkouts;
    }
    
}
