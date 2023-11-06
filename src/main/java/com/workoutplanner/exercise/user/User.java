package com.workoutplanner.exercise.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// import java.util.List;

// import com.workoutplanner.exercise.user_created_workout.UserCreatedWorkout;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @OneToMany(mappedBy = "user")
    private Integer userId;

    private String name;

    private String email;

    // @OneToMany(mappedBy = "user")
    // private List<UserCreatedWorkout> userCreatedWorkouts;

    protected User() {
    }


    public User(Integer id, String name, String email) {
        this.userId = id;
        this.name = name;
        this.email = email;
    }


    public Integer getId() {
        return this.userId;
    }

    public void setId(Integer id) {
        this.userId = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}