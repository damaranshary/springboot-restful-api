package com.prodemy.springbootrestfulapi.controller;

import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.LoginUserRequest;
import com.prodemy.springbootrestfulapi.model.TokenResponse;
import com.prodemy.springbootrestfulapi.model.UserResponse;
import com.prodemy.springbootrestfulapi.model.WebResponse;
import com.prodemy.springbootrestfulapi.service.AuthService;
import com.prodemy.springbootrestfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<TokenResponse> login(@RequestBody LoginUserRequest request){
        TokenResponse tokenResponse = authService.login(request);
        return WebResponse.<TokenResponse>builder().data(tokenResponse).build();
    }
}
