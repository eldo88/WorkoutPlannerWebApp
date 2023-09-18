package com.workoutplanner.workouts;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.workoutplanner.exercise.user.UserController;

@SpringBootTest
@ContextConfiguration(classes = UserController.class)
public class UserControllerSmokeTest {

    @Autowired
    private UserController userController;

    @Test
    public void contextLoads() throws Exception {
        assertThat(userController).isNotNull();
    }
    
}
