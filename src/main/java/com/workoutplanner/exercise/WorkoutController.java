package com.workoutplanner.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(path= "/all/random")
    public @ResponseBody Iterable<Workout> random() {
        return workoutService.returnRandomWorkoutsByTargetMuscleGroup();
    }

    @GetMapping(path = "/all/random-workout")
    public @ResponseBody Workout randomWorkout() {
        return workoutService.returnRandomWorkout();
    }

    @GetMapping(path = "/all/workout-target-muscle-group")
    public @ResponseBody Iterable<Workout> returnByTargetMuscleGroup() {
        return workoutService.returnAllWorkoutsByTargetMuscleGroup();
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody ResponseEntity<Integer> deleteById(@PathVariable("id") Integer id) {
        workoutService.deleteWorkoutById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
