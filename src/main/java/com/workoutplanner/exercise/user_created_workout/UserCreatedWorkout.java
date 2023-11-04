package com.workoutplanner.exercise.user_created_workout;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;


import com.workoutplanner.exercise.exercise.Exercise;
import com.workoutplanner.exercise.user.User;

@Entity
@Table(name="user_created_workout")
public class UserCreatedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="workout_id")
    private Integer workoutId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userCreatedWorkout")
    private List<Exercise> exercises;

    private String workoutName;

    private LocalDate createdDate;


    public UserCreatedWorkout() {
    }


    public Integer getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public String getWorkoutName() {
        return this.workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    
}
