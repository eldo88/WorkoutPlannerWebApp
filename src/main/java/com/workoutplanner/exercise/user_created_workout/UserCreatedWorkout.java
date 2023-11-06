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

@Entity
@Table(name="user_created_workout")
public class UserCreatedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="workout_id")
    private Integer workoutId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Integer userId;

    @OneToMany(mappedBy = "exerciseId")
    private List<Integer> exerciseIds;

    private String workoutName;

    private LocalDate createdDate;


    public UserCreatedWorkout() {
    }


    public UserCreatedWorkout(Integer userId, List<Integer> exerciseIds, String workoutName) {
        this.userId = userId;
        this.exerciseIds = exerciseIds;
        this.workoutName = workoutName;
    }

    public Integer getWorkoutId() {
        return this.workoutId;
    }

    public void setWorkoutId(Integer workoutId) {
        this.workoutId = workoutId;
    }

    public Integer getUser() {
        return this.userId;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
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
