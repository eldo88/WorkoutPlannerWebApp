package com.workoutplanner.exercise.user_created_workout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserCreatedWorkoutController {

    @Autowired
    UserCreatedWorkoutService userCreatedWorkoutService;
    

    @PostMapping(path = "create/workout")
    public @ResponseBody void createWorkout(
        @RequestParam Integer userId,
        @RequestParam String workoutName,
        @RequestParam List<Integer> exerciseIds,
        Model model) {
        
            userCreatedWorkoutService.createWorkout(userId, workoutName, exerciseIds);
    }
}
