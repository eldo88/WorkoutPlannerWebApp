package com.workoutplanner.workouts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkoutControllerSmokeTest {

    @Autowired
    private WorkoutController workoutController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(workoutController).isNotNull();
    }
    
}
