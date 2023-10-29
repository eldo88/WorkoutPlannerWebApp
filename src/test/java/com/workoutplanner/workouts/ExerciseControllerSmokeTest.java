package com.workoutplanner.workouts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.workoutplanner.exercise.exercise.ExerciseController;


@SpringBootTest(classes = ExerciseController.class)
public class ExerciseControllerSmokeTest {

    @Autowired
    private ExerciseController exerciseController;


    @Test
    public void contextLoads() throws Exception {
        assertThat(exerciseController).isNotNull();
    }
    
}
