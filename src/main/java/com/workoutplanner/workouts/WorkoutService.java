package com.workoutplanner.workouts;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;


    public WorkoutService() {
    }


    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public void addNewWorkout(String workoutName,
        String workoutType,
        Integer defaultSets,
        Integer defaultReps,
        WorkoutTargetMuscleGroup targetMuscleGroup) {
        
        Workout w = new Workout();
        w.setWorkoutName(workoutName);
        w.setWorkoutType(workoutType);
        w.setDefaultSets(defaultSets);
        w.setDefaultReps(defaultReps);
        w.setTargetMuscleGroup(targetMuscleGroup);
        workoutRepository.save(w);
    }

    public Iterable<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Iterable<Workout> getWorkoutByName(String workoutName) {
        return workoutRepository.findByWorkoutName(workoutName);
    }

    public Iterable<Workout> getWorkoutsByType(String workoutType) {
        return workoutRepository.findByWorkoutType(workoutType);
    }

    public Workout getById(Integer id) {
        Optional<Workout> oWorkout = workoutRepository.findById(id);
        return oWorkout.get();
    }

    public int workoutTypeCount(String workoutType) {
        Iterable<Workout> iWorkout = workoutRepository.findByWorkoutType(workoutType);

        int typeCount = 0;
        for (Workout workout : iWorkout) {
            typeCount++;
        }
        return typeCount;
    }

    public Workout returnRandomWorkout() {
        long longRowCount = workoutRepository.count();
        int rowCount = (int)longRowCount;
        int min = 1;

        int randomNum = (int)Math.floor(Math.random() * (rowCount- min + 1) + min);
        Integer randomWorkoutID = Integer.valueOf(randomNum);

        List<Workout> allWorkouts = workoutRepository.findAll();

        return allWorkouts.get(randomWorkoutID);
    }
    
}
