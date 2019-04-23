package com.spring.boot.example.repository;

import com.spring.boot.example.model.User;
import org.springframework.data.repository.CrudRepository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
//
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
}
