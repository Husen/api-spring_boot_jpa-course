package com.example.demo.service;

import com.example.demo.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    void updateById(User user);
}
