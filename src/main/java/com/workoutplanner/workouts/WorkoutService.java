package com.workoutplanner.workouts;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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

    public int workoutTargetMuscleGroupCount(Iterable<Workout> iWorkout) {
        //Iterable<Workout> iWorkout = workoutRepository.findByTargetMuscleGroup(targetMuscleGroup);

        int typeCount = 0;
        for (Workout workout : iWorkout) {
            typeCount++;
        }
        return typeCount;
    }

    public Iterable<Workout> returnRandomWorkoutsByTargetMuscleGroup() {

        Random rand = new Random();
        int randomNum;
        List<Workout> finalRandomWorkouts = new ArrayList<>();

        for (WorkoutTargetMuscleGroup TMG : WorkoutTargetMuscleGroup.values()) {
            List<Workout> randomWorkouts = workoutRepository.findByTargetMuscleGroup(TMG);
            int count = workoutTargetMuscleGroupCount(randomWorkouts);
            if (count == 1) {
                randomNum = 0;
            }
            else {
                count = count - 1;
                int min = 1;
                randomNum = (int)Math.floor(Math.random() * (count- min + 1) + min);
            }
            finalRandomWorkouts.add(randomWorkouts.get(randomNum));
        }
        Iterable<Workout> test = finalRandomWorkouts;
        return test;
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
