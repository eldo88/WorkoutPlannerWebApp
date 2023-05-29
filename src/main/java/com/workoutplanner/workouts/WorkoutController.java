package com.workoutplanner.workouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.query.Param;


@Controller
public class WorkoutController {
    
    @Autowired 
    private WorkoutRepository workoutRepository;

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

    @GetMapping(path ="/all/workout")
    public @ResponseBody Iterable<Workout> getAllWorkouts(Model model) {

        model.addAttribute("workouts", workoutRepository);
        return workoutRepository.findAll();
    }

    
    @GetMapping("/get-all-workouts")
    public Iterable<Workout> getWorkouts(Model model) {

        model.addAttribute("workouts", workoutRepository.findAll());
        return workoutRepository.findAll();
    }

    @GetMapping(path="/all/workout/find-by-name") 
    public @ResponseBody Iterable<Workout> getWorkoutByName(@Param("workoutName") String workoutName) {

        return workoutRepository.findByWorkoutName(workoutName);
    }
    
    @GetMapping(path="/all/workout/find-by-type")
    public @ResponseBody Iterable<Workout> getWorkoutByType(@Param("workoutType") String workoutType) {

        //Workout workout = workoutRepository.findByWorkoutType(workoutType);
        return workoutRepository.findByWorkoutType(workoutType);
    }

    //works but only returns int and no JSON
    @GetMapping(path ="/all/count")
    public @ResponseBody Integer count(@Param("workoutType") String workoutType) {
        return workoutService.workoutTypeCount(workoutType);
    }
}
