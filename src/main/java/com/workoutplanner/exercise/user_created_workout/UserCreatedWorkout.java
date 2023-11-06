package com.workoutplanner.exercise.user_created_workout;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

import com.workoutplanner.exercise.user.User;


// import com.workoutplanner.exercise.exercise.Exercise;

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

    @ElementCollection
    private List<Integer> exerciseIds;

    private String workoutName;

    private LocalDate createdDate;


    public UserCreatedWorkout() {
    }


    public UserCreatedWorkout(User user, List<Integer> exerciseIds, String workoutName) {
        this.user= user;
        this.exerciseIds = exerciseIds;
        this.workoutName = workoutName;
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

    public List<Integer> getExerciseIds() {
        return this.exerciseIds;
    }

    public void setExercises(List<Integer> exerciseIds) {
        this.exerciseIds = exerciseIds;
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
