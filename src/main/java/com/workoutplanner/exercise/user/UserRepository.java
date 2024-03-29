package com.workoutplanner.exercise.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(@Param("name") String name);

    List<User> findByEmail(@Param("email") String email);

    void deleteById(@Param("id") Integer id);
}
