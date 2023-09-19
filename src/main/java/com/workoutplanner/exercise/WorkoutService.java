package com.workoutplanner.exercise;

import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        LocalDate date = LocalDate.now();
        w.setWorkoutName(workoutName);
        w.setWorkoutType(workoutType);
        w.setDefaultSets(defaultSets);
        w.setDefaultReps(defaultReps);
        w.setDate(date);
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

    public Iterable<Workout> returnRandomWorkoutsByTargetMuscleGroup() {
        int randomNum;

        List<Workout> finalRandomWorkouts = new ArrayList<>();
        List<Workout> randomWorkouts = new ArrayList<>();

        for (WorkoutTargetMuscleGroup TMG : WorkoutTargetMuscleGroup.values()) {
            randomWorkouts = workoutRepository.findByTargetMuscleGroup(TMG);
            int count = randomWorkouts.size();
            if (count == 1) {
                randomNum = 0;
            }
            else {
                count = count - 1;
                int min = 0;
                randomNum = (int)Math.floor(Math.random() * (count- min + 1) + min);
            }
            finalRandomWorkouts.add(randomWorkouts.get(randomNum));
            randomWorkouts.clear();
        }
        Iterable<Workout> workouts = finalRandomWorkouts;

        return workouts;
    }

    public Workout returnRandomWorkout() {
        long longRowCount = workoutRepository.count();
        int rowCount = (int)longRowCount;
        int min = 0;
        rowCount = rowCount - 1;
        int randomNum = (int)Math.floor(Math.random() * (rowCount- min + 1) + min);

        Integer randomWorkoutID = Integer.valueOf(randomNum);

        List<Workout> allWorkouts = workoutRepository.findAll();

        return allWorkouts.get(randomWorkoutID);
    }

    public Iterable<Workout> returnAllWorkoutsByTargetMuscleGroup() {

        List<Workout> workoutList = new ArrayList<>();
       
        for (WorkoutTargetMuscleGroup i : WorkoutTargetMuscleGroup.values()) {
            workoutList = workoutRepository.findByTargetMuscleGroup(i);
        }
        Iterable<Workout> finalWorkout = workoutList;

        return finalWorkout;
    }

    void deleteWorkoutById(Integer id) {
        workoutRepository.deleteById(id);
    }

    // curl -X PUT http://localhost:8080/all/workout/update/id\?id\=264 
    // -H 'Content-type:application/json' 
    // -d '{"workoutName": "tricep-press", "workoutType": "weights", "defaultSets": "3", "defaultReps": "10", "oneRepMax": "80", "workoutWeight": "35", "date": "2023-09-18", "targetMuscleGroup": "UPPERBODY"}'

    public Workout updateWorkout(Integer id, Workout workout) {
        Workout updateWorkout = workoutRepository.findById(id)
        .orElseThrow(() -> new WorkoutResourceNotFoundException("Workout not found for id: " + id));

        updateWorkout.setWorkoutName(workout.getWorkoutName());
        updateWorkout.setWorkoutType(workout.getWorkoutType());
        updateWorkout.setDefaultSets(workout.getDefaultSets());
        updateWorkout.setDefaultReps(workout.getDefaultReps());
        updateWorkout.setOneRepMax(workout.getOneRepMax());
        updateWorkout.setWorkoutWeight(workout.getWorkoutWeight());
        updateWorkout.setDate(workout.getDate());
        updateWorkout.setTargetMuscleGroup(workout.getTargetMuscleGroup());

        workoutRepository.save(updateWorkout);

        return updateWorkout;
    }
    
}
