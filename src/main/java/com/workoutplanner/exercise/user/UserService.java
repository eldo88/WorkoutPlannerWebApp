package com.workoutplanner.exercise.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService() {

    }

    public User addNewUser(User newUser) {

        return userRepository.save(newUser);
        //return "User Saved";
        // TODO: add JWT to send JSON token back to browser to validate input
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Iterable<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public Iterable<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public User findById(Integer id) {
        User user = userRepository.findById(id)
        .orElseThrow(() -> new UserResourceNotFoundException("User not found for id" + id));
        return user;
    }

    public User updateUser(Integer id, User user) {
        User updateUser = userRepository.findById(id)
        .orElseThrow(() -> new UserResourceNotFoundException("User doesn't exist with id: " + id));

        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());

        userRepository.save(updateUser);

        return updateUser;
    }
    
}
