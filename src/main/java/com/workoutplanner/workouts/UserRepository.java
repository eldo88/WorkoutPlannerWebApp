package com.workoutplanner.workouts;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
//import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//import com.workoutplanner.workouts.User;
// @RepositoryRestResource(collectionResourceRel = "name", path = "/find")
// public interface UserRepository extends PagingAndSortingRepository<User, Integer>,
// CrudRepository<User, Integer> {

//     List<User> findByName(@Param("name") String name);
    
// }

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(@Param("name") String name);

    List<User> findByEmail(@Param("email") String email);
}
