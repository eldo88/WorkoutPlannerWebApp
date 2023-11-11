package com.workoutplanner.exercise.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

import com.workoutplanner.exercise.user_created_workout.UserCreatedWorkout;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    private String name;

    private String email;

    private String userName;

    private boolean isAdmin;

    private LocalDate createdDate;

    @OneToMany(mappedBy = "user")
    private List<UserCreatedWorkout> userCreatedWorkouts;

    public User() {
    }

    public User(Integer id, String name, String email, String userName, boolean isAdmin) {
        this.userId = id;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.isAdmin = isAdmin;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

}