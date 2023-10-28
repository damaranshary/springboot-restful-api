package com.prodemy.springbootrestfulapi.service;

import com.prodemy.springbootrestfulapi.model.LoginUserRequest;
import com.prodemy.springbootrestfulapi.model.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginUserRequest request);
}
