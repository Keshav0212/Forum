package com.project.forum.repository;

import com.project.forum.dto.UserDto;
import com.project.forum.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String > {

    Optional<User> findByUsername(String username);
}
