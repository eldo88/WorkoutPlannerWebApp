package com.workoutplanner.workouts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.query.Param;


//These endpoints are used to add data ONLY via http, adding data to the following tables in the workout_planner_web_app db 
//will cause PK Id fields to get out of synch

@Controller
@RequestMapping(path="/main")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add/user")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email, Model model) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        model.addAttribute("name", n);
        userRepository.save(n);
        return "User Saved";
    }

    @GetMapping(path ="/all/user")
    public @ResponseBody Iterable<User> getAllUsers() {
        // returns a JSON or XML with all users
        return userRepository.findAll();
    }

    @GetMapping(path ="/all/user/find-by-name")
    public @ResponseBody Iterable<User> getUsersByName(@Param("name") String name) {
       
        return userRepository.findByName(name);
    }

    @GetMapping(path="/all/user/find-by-email")
    public @ResponseBody Iterable<User> getUserByEmail(@Param("email") String email) {

        return userRepository.findByEmail(email);
    }

/*************************************************************************************************************************/

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
    public @ResponseBody Iterable<Workout> getAllWorkouts() {

        return workoutRepository.findAll();
    }

    @GetMapping(path="/all/workout/find-by-name") 
    public @ResponseBody Iterable<Workout> getWorkoutByName(@Param("workoutName") String workoutName) {

        return workoutRepository.findByWorkoutName(workoutName);
    }
    
    @GetMapping(path="/all/workout/find-by-type")
    public @ResponseBody Iterable<Workout> getWorkoutByType(@Param("workoutType") String workoutType) {

        return workoutRepository.findByWorkoutType(workoutType);
    }
}
