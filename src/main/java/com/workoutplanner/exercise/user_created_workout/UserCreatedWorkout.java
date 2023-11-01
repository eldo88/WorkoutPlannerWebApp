package com.workoutplanner.exercise.user_created_workout;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

import com.workoutplanner.exercise.exercise.Exercise;

@Entity
@Table(name="user_created_workout")
public class UserCreatedWorkout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="workout_id")
    private Integer id;

    @OneToMany(mappedBy = "userCreatedWorkout")
    private Set<Exercise> exercises;
    
}
