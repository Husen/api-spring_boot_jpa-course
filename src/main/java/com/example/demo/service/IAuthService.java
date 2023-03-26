package com.example.demo.service;

import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RegisterRequest;

public interface IAuthService {
    String register(RegisterRequest registerRequest);
    String login(LoginRequest loginRequest);
}
