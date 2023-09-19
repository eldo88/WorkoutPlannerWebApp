package com.workoutplanner.exercise.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserResourceNotFoundException extends RuntimeException{

    public UserResourceNotFoundException(String message){
        super(message);
    }
}
