package com.workoutplanner.exercise.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping(path ="/add/exercise")
    public @ResponseBody void addNewExercise (
        @RequestParam String exerciseName, 
        @RequestParam String exerciseType,
        @RequestParam Integer defaultSets, 
        @RequestParam Integer defaultReps, 
        @RequestParam ExerciseTargetMuscleGroup targetMuscleGroup, Model model) {

        exerciseService.addNewExercise(exerciseName, exerciseType, defaultSets, defaultReps, targetMuscleGroup);
    }
    
    @GetMapping(path="/all/exercises")
    public @ResponseBody Iterable<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping(path="/all/exercise/find-by-name") 
    public @ResponseBody Iterable<Exercise> getExerciseByName(@RequestParam(name = "exerciseName", required = true) String exerciseName) {
        return exerciseService.getExerciseByName(exerciseName);
    }
    
    @GetMapping(path="/all/exercise/find-by-type")
    public @ResponseBody Iterable<Exercise> getExerciseByType(@RequestParam(name ="exerciseType", required = true) String exerciseType) {
        return exerciseService.getExerciseByType(exerciseType);
    }

    @GetMapping(path="/all/exercise/find-by-id")
    public @ResponseBody Exercise getById(@RequestParam(name = "id", required = true) Integer id) {
        return exerciseService.getById(id);
    }

    @GetMapping(path= "/all/random")
    public @ResponseBody Iterable<Exercise> random() {
        return exerciseService.returnRandomExercisesByTargetMuscleGroup();
    }

    @GetMapping(path = "/all/random-exercise")
    public @ResponseBody Exercise randomExercise() {
        return exerciseService.returnRandomExercise();
    }

    @GetMapping(path = "/all/exercise-target-muscle-group")
    public @ResponseBody Iterable<Exercise> returnByTargetMuscleGroup() {
        return exerciseService.returnAllExercisesByTargetMuscleGroup();
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody ResponseEntity<Integer> deleteById(@PathVariable("id") Integer id) {
        exerciseService.deleteWorkoutById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // curl -X PUT http://localhost:8080/all/workout/update/id\?id\=209 -H 'Content-type:application/json' -d '{"name": "Samwise", "email": "test@bearer.com"}'
    
    @PutMapping(path = "/all/workout/update/{id}")
    public @ResponseBody ResponseEntity<Exercise> updateUser(@Param("id") Integer id, @RequestBody Exercise updateExercise) {

        exerciseService.updateExercise(id, updateExercise);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
