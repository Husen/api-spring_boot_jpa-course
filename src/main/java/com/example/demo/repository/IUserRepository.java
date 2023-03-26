package com.example.demo.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
//    Iterable<User> findByNameContains(String name);
//    User findByEmail(String email);
//    User findByPassword(String password);
//    User findByEmailAndPassword(String email, String password);
}
