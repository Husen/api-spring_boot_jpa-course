package com.example.demo.service;

import com.example.demo.model.entity.Auth;
import com.example.demo.model.entity.User;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.request.RegisterRequest;
import com.example.demo.repository.IAuthRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.utils.validation.JwtUtil;
import jakarta.persistence.EntityExistsException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService{
    @Autowired
    private IAuthRepository authRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String register(RegisterRequest registerRequest) {
        try {
            Auth auth = modelMapper.map(registerRequest, Auth.class);
            Auth resultAuth = authRepository.save(auth);

            User user = modelMapper.map(registerRequest, User.class);
            user.setAuth(resultAuth);
            userRepository.save(user);

            String token = jwtUtil.generateToken(user.getAuth().getEmail());
            return token;
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistsException();
        }
    }

    @Override
    public String login(LoginRequest loginRequest) {
        try {
            Optional<Auth> auth = authRepository.findById(loginRequest.getEmail());
            if (auth.isEmpty()) {
                throw new RuntimeException("Email not registered...");
            }
            if (!auth.get().getPassword().equals(loginRequest.getPassword())) {
                throw new Exception("Incorrect password");
            }
            String token = jwtUtil.generateToken(loginRequest.getEmail());
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
