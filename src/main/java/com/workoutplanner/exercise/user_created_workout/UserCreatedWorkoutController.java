package com.workoutplanner.exercise.user_created_workout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserCreatedWorkoutController {

    @Autowired
    UserCreatedWorkoutService userCreatedWorkoutService;
    

    @PostMapping(path = "/create/workout")
    public @ResponseBody void createWorkout(
        @RequestParam Integer userId,
        @RequestParam String workoutName,
        @RequestParam List<Integer> exerciseIds,
        Model model) {
        
            userCreatedWorkoutService.createWorkout(userId, workoutName, exerciseIds);
    }

    @PostMapping(path = "/created/workout")
    public @ResponseBody UserCreatedWorkout createdWorkout(@RequestBody UserCreatedWorkout userCreatedWorkout) {
        
        return userCreatedWorkoutService.createdWorkout(userCreatedWorkout);
    }

    @GetMapping(path = "/workouts/{userId}")
    public @ResponseBody Iterable<UserCreatedWorkout> getUserWorkouts(@PathVariable("userId") Integer userId) {
        return userCreatedWorkoutService.getUserWorkouts(userId);
    }
    
}
