package com.workoutplanner.exercise.exercise;

import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;


    public ExerciseService() {
    }


    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void addNewExercise(String exerciseName,
        String workoutType,
        Integer defaultSets,
        Integer defaultReps,
        ExerciseTargetMuscleGroup targetMuscleGroup) {
        
        Exercise e = new Exercise();
        LocalDate date = LocalDate.now();
        e.setExerciseName(exerciseName);
        e.setExerciseType(workoutType);
        e.setDefaultSets(defaultSets);
        e.setDefaultReps(defaultReps);
        e.setDate(date);
        e.setExerciseTargetMuscleGroup(targetMuscleGroup);
        exerciseRepository.save(e);
    }

    public Iterable<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Iterable<Exercise> getExerciseByName(String exerciseName) {
        return exerciseRepository.findByExerciseName(exerciseName);
    }

    public Iterable<Exercise> getExerciseByType(String exerciseType) {
        return exerciseRepository.findByExerciseType(exerciseType);
    }

    public Exercise getById(Integer id) {
        Optional<Exercise> oExercise = exerciseRepository.findById(id);
        return oExercise.get();
    }

    public Iterable<Exercise> returnRandomExercisesByTargetMuscleGroup() {
        int randomNum;

        List<Exercise> finalRandomExercises = new ArrayList<>();
        List<Exercise> randomExercises = new ArrayList<>();

        for (ExerciseTargetMuscleGroup TMG : ExerciseTargetMuscleGroup.values()) {
            randomExercises = exerciseRepository.findByTargetMuscleGroup(TMG);
            int count = randomExercises.size();
            if (count == 1) {
                randomNum = 0;
            }
            else {
                count = count - 1;
                int min = 0;
                randomNum = (int)Math.floor(Math.random() * (count- min + 1) + min);
            }
            finalRandomExercises.add(randomExercises.get(randomNum));
            randomExercises.clear();
        }
        Iterable<Exercise> exercises = finalRandomExercises;

        return exercises;
    }

    public Exercise returnRandomExercise() {
        long longRowCount = exerciseRepository.count();
        int rowCount = (int)longRowCount;
        int min = 0;
        rowCount = rowCount - 1;
        int randomNum = (int)Math.floor(Math.random() * (rowCount- min + 1) + min);

        Integer randomExerciseID = Integer.valueOf(randomNum);

        List<Exercise> allExercises = exerciseRepository.findAll();

        return allExercises.get(randomExerciseID);
    }

    public Iterable<Exercise> returnAllExercisesByTargetMuscleGroup() {

        List<Exercise> exerciseList = new ArrayList<>();
       
        for (ExerciseTargetMuscleGroup i : ExerciseTargetMuscleGroup.values()) {
            exerciseList = exerciseRepository.findByTargetMuscleGroup(i);
        }
        Iterable<Exercise> finalExercise = exerciseList;

        return finalExercise;
    }

    void deleteWorkoutById(Integer id) {
        exerciseRepository.deleteById(id);
    }

    // curl -X PUT http://localhost:8080/all/workout/update/id\?id\=264 
    // -H 'Content-type:application/json' 
    // -d '{"workoutName": "tricep-press", "workoutType": "weights", "defaultSets": "3", "defaultReps": "10", "oneRepMax": "80", "workoutWeight": "35", "date": "2023-09-18", "targetMuscleGroup": "UPPERBODY"}'

    public Exercise updateExercise(Integer id, Exercise exercise) {
        Exercise updateExercise = exerciseRepository.findById(id)
        .orElseThrow(() -> new ExerciseResourceNotFoundException("Workout not found for id: " + id));

        updateExercise.setExerciseName(exercise.getExerciseName());
        updateExercise.setExerciseType(exercise.getExerciseType());
        updateExercise.setDefaultSets(exercise.getDefaultSets());
        updateExercise.setDefaultReps(exercise.getDefaultReps());
        updateExercise.setOneRepMax(exercise.getOneRepMax());
        updateExercise.setExerciseWeight(exercise.getExerciseWeight());
        updateExercise.setDate(exercise.getDate());
        updateExercise.setExerciseTargetMuscleGroup(exercise.getTargetMuscleGroup());

        exerciseRepository.save(updateExercise);

        return updateExercise;
    }
    
}
