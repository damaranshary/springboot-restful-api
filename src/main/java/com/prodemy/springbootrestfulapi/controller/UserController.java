package com.prodemy.springbootrestfulapi.controller;

import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.RegisterUserRequest;
import com.prodemy.springbootrestfulapi.model.UpdateUserRequest;
import com.prodemy.springbootrestfulapi.model.UserResponse;
import com.prodemy.springbootrestfulapi.model.WebResponse;
import com.prodemy.springbootrestfulapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);

        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> getUser(User user) {
        UserResponse userResponse = userService.getUser(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> updateUser(User user, @RequestBody UpdateUserRequest request) {
        UserResponse userResponse = userService.updateUser(user, request);

        return WebResponse.<UserResponse>builder()
                .data(userResponse).build();
    }
}
