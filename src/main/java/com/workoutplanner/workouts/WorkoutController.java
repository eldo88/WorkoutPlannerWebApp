package com.workoutplanner.workouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.query.Param;


@Controller
public class WorkoutController {
    
    @Autowired 
    private WorkoutRepository workoutRepository;

    @PostMapping(path ="/add/workout")
    public @ResponseBody String addNewWorkout (@RequestParam String workoutName, @RequestParam String workoutType, Model model) {

        Workout w = new Workout();
        w.setWorkoutName(workoutName);
        w.setWorkoutType(workoutType);
        model.addAttribute("workoutType", w);
        workoutRepository.save(w);
        return "Workout Saved";
    }

    @GetMapping(path ="/all/workout")
    public @ResponseBody Iterable<Workout> getAllWorkouts(Model model) {

        model.addAttribute("workouts", workoutRepository);
        return workoutRepository.findAll();
    }

    //doesn't work
    @GetMapping("/index")
    public String getWorkouts(Model model) {

        model.addAttribute("workouts", workoutRepository.findAll());
        return "index";
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
}
