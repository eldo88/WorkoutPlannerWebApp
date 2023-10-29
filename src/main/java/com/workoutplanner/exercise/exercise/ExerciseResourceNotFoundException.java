package com.workoutplanner.exercise.exercise;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExerciseResourceNotFoundException extends RuntimeException{

    public ExerciseResourceNotFoundException(String message){
        super(message);
    }
}
