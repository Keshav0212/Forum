package com.project.forum.repository;

import com.project.forum.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import com.project.forum.response.GetUsersResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String > {

//    Optional<User> findByUsername(String username);

    User findByUsername(String username);

    boolean existsByUsername(String username);

}
