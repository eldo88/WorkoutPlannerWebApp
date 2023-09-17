package com.workoutplanner.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.query.Param;


//These endpoints are used to add data ONLY via http, adding data to the following tables in the workout_planner_web_app db 
//will cause PK Id fields to get out of synch

@Controller
//@RequestMapping(path="/main")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path="/add/user")
    public @ResponseBody void addNewUser (@RequestParam String name, @RequestParam String email) {

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        //return "User Saved";
        // TODO: add JWT to send JSON token back to browser to validate input
    }

    @GetMapping(path ="/all/user")
    public @ResponseBody Iterable<User> getAllUsers(Model model) {
        
        model.addAttribute("users", userRepository.findAll());
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

}
