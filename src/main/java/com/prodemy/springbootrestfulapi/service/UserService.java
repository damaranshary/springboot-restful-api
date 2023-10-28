package com.prodemy.springbootrestfulapi.service;

import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.RegisterUserRequest;
import com.prodemy.springbootrestfulapi.model.UpdateUserRequest;
import com.prodemy.springbootrestfulapi.model.UserResponse;

import java.util.Optional;

public interface UserService {
    void register(RegisterUserRequest request);

    UserResponse getUser(User user);

    UserResponse updateUser(User user, UpdateUserRequest request);

    Optional<User> findFirstByToken(String token);
}
