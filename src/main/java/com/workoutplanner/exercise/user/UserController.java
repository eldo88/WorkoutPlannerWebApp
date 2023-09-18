package com.workoutplanner.exercise.user;


import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


//These endpoints are used to add data ONLY via http, adding data to the following tables in the workout_planner_web_app db 
//will cause PK Id fields to get out of synch

@Controller
//@RequestMapping(path="/main")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path="/add/user")
    public @ResponseBody void addNewUser (@RequestParam String name, @RequestParam String email) {

        // User n = new User();
        // n.setName(name);
        // n.setEmail(email);
        // userRepository.save(n);
        // //return "User Saved";
        // // TODO: add JWT to send JSON token back to browser to validate input
    }

    @GetMapping(path ="/all/user")
    public @ResponseBody Iterable<User> getAllUsers(Model model) {
        
        // model.addAttribute("users", userRepository.findAll());
        return userService.getAllUsers();
    }

    @GetMapping(path ="/all/user/find-by-name")
    public @ResponseBody Iterable<User> getUsersByName(@Param("name") String name) {
       
        return userService.getUsersByName(name);
    }

    @GetMapping(path="/all/user/find-by-email")
    public @ResponseBody Iterable<User> getUserByEmail(@Param("email") String email) {

        return userService.getUserByEmail(email);
    }

    @DeleteMapping(path = "/all/users/delete-by-id/{id}")
    public @ResponseBody ResponseEntity<Integer> deleteByName(@Param("id") Integer id) {

        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/all/users/update/{id}")
    public @ResponseBody ResponseEntity<User> updateUser(@Param("id") Integer id, @RequestBody User updateUser) {

        userService.updateUser(id, updateUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
