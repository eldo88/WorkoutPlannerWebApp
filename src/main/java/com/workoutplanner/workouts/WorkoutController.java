package com.workoutplanner.workouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping(path ="/add/workout")
    public @ResponseBody void addNewWorkout (
        @RequestParam String workoutName, 
        @RequestParam String workoutType,
        @RequestParam Integer defaultSets, 
        @RequestParam Integer defaultReps, 
        @RequestParam WorkoutTargetMuscleGroup targetMuscleGroup, Model model) {

        workoutService.addNewWorkout(workoutName, workoutType, defaultSets, defaultReps, targetMuscleGroup);
    }
    
    @GetMapping(path="/all/workout")
    public @ResponseBody Iterable<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping(path="/all/workout/find-by-name") 
    public @ResponseBody Iterable<Workout> getWorkoutByName(@RequestParam(name = "workoutName", required = true) String workoutName) {
        return workoutService.getWorkoutByName(workoutName);
    }
    
    @GetMapping(path="/all/workout/find-by-type")
    public @ResponseBody Iterable<Workout> getWorkoutByType(@RequestParam(name ="workoutType", required = true) String workoutType) {
        return workoutService.getWorkoutsByType(workoutType);
    }

    @GetMapping(path="/all/workout/find-by-id")
    public @ResponseBody Workout getById(@RequestParam(name = "id", required = true) Integer id) {
        return workoutService.getById(id);
    }

    //works but only returns int and no JSON
    @GetMapping(path ="/all/count")
    public @ResponseBody Integer count(@RequestParam(name = "workoutType", required = true) String workoutType) {
        return workoutService.workoutTypeCount(workoutType);
    }

    @GetMapping(path = "/all/random-workout")
    public @ResponseBody Workout randomWorkout() {
        return workoutService.returnRandomWorkout();
    }
}
