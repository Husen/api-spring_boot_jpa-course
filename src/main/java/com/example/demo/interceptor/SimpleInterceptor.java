package com.example.demo.interceptor;

import com.example.demo.utils.validation.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class SimpleInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        if (request.getRequestURI().contains("login") || request.getRequestURI().contains("register")) {
//            return true;
//        }
//
//        String token = request.getHeader("Authorization");
//        if (token == null)
//            throw new RuntimeException("Token not found !");
//        String[] bearerToken = token.split(" ");
//        return jwtUtil.validateToken(bearerToken[1]);

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("POST HANDLE");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("COMPLETE");
    }

}
