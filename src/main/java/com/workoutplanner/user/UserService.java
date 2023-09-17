package com.workoutplanner.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    public void addNewUser(String name, String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        //return "User Saved";
        // TODO: add JWT to send JSON token back to browser to validate input
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Iterable<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public Iterable<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
