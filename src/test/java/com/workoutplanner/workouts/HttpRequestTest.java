package com.workoutplanner.workouts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.workoutplanner.exercise.exercise.ExerciseController;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ExerciseController.class)
public class HttpRequestTest {

    @Value(value = "${local.server.port}")
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldContainWorkoutName() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/all/workout", String.class))
        .contains("workoutName", "workoutType", "defaultSets", "defaultReps");
    }

}
