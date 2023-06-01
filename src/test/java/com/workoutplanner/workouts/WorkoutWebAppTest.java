package com.workoutplanner.workouts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WorkoutWebAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnWorkoutName() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-name").param("workoutName", "Bench-press"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    public void shouldReturnError_requiredParamWorkoutNameMissing() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-name"))
        .andExpect(status().isBadRequest())
        .andDo(print());
    }

    @Test
    public void shouldReturnWorkoutType() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-type").param("workoutType", "Lifting"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    public void shouldReturnError_requiredParamWorkoutTypeMissing() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-type"))
        .andExpect(status().isBadRequest())
        .andDo(print());
    }

    @Test
    public void shouldReturnWorkoutById() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-id").param("id", "1"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    public void shouldReturnError_requiredParamIdMissing() throws Exception {
        this.mockMvc.perform(get("/all/workout/find-by-id"))
        .andExpect(status().isBadRequest())
        .andDo(print());
    }

    @Test
    public void shouldReturnWorkoutCount() throws Exception {
        this.mockMvc.perform(get("/all/count").param("workoutType", "Lifting"))
        .andExpect(status().isOk())
        .andDo(print());
    }

    @Test
    public void shouldReturnError_requiredParamWorkoutTypeMissingForCount() throws Exception {
        this.mockMvc.perform(get("/all/count"))
        .andExpect(status().isBadRequest())
        .andDo(print());
    }

    @Test
    public void shouldReturnRandomWorkout() throws Exception {
        this.mockMvc.perform(get("/all/random-workout"))
        .andExpect(status().isOk())
        .andDo(print());
    }
    
}
