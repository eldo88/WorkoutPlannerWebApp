package com.workoutplanner.workouts;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;


    public WorkoutService() {
    }


    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout findById(Integer id) {
        Optional<Workout> oWorkout = workoutRepository.findById(id);
        return oWorkout.get();
    }

    public Iterable<Workout> findByWorkoutName(String workoutName) {
        Iterable<Workout> iWorkout = workoutRepository.findByWorkoutName(workoutName);
        return iWorkout;
    }

    public int workoutTypeCount(String workoutType) {
    
        Iterable<Workout> iWorkout = workoutRepository.findByWorkoutType(workoutType);

        int typeCount = 0;
        for (Workout workout : iWorkout) {
            typeCount++;
        }
        return typeCount;
    }

    public Optional<Workout> returnRandomWorkout() {
        long longRowCount = workoutRepository.count();
        int rowCount = (int)longRowCount;
        int min = 1;

        int randomNum = (int)Math.floor(Math.random() * (rowCount- min + 1) + min);
        Integer randomWorkoutID = Integer.valueOf(randomNum);

        return workoutRepository.findById(randomWorkoutID);
    }
    
}
