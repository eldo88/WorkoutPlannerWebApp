package com.workoutplanner.exercise.user;


import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.repository.query.Param;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.stream.Collectors;

import java.util.List;


//These endpoints are used to add data ONLY via http, adding data to the following tables in the workout_planner_web_app db 
//will cause PK Id fields to get out of synch

@RestController
//@RequestMapping(path="/main")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserModelAssembler assembler;

    @PostMapping(path="/add/user")
    public ResponseEntity<?> addNewUser (@RequestBody User newUser) {
        EntityModel<User> entityModel = assembler.toModel(userService.addNewUser(newUser));

        return ResponseEntity
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
        .body(entityModel);
    }

    @GetMapping(path="/user/{id}")
    EntityModel<User> one(@PathVariable Integer id) {
        User user = userService.findById(id);

        return assembler.toModel(user);
    }


    @GetMapping(path ="/users")
    CollectionModel<EntityModel<User>> getAllUsers() {
        
        List<EntityModel<User>> user = userService.getAllUsers().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

        return CollectionModel.of(user, linkTo(methodOn(UserController.class)
        .getAllUsers())
        .withSelfRel());
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

    // curl -X PUT http://localhost:8080/all/users/update/id\?id\=209 -H 'Content-type:application/json' -d '{"name": "Samwise", "email": "test@bearer.com"}'

    @PutMapping(path = "/all/users/update/{id}")
    public @ResponseBody ResponseEntity<User> updateUser(@Param("id") Integer id, @RequestBody User updateUser) {

        userService.updateUser(id, updateUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
