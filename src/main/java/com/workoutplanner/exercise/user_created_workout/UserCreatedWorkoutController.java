package com.workoutplanner.exercise.user_created_workout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.workoutplanner.exercise.user.User;

@Controller
public class UserCreatedWorkoutController {

    @Autowired
    UserCreatedWorkoutService userCreatedWorkoutService;

    @Autowired
    User user;
    

    @PostMapping(path = "create/workout")
    public void createWorkout(
        @RequestParam User userId,
        @RequestParam String workoutName,
        @RequestParam List<Integer> exerciseIds) {
        
            userCreatedWorkoutService.createWorkout(userId, workoutName, exerciseIds);
    }
}
