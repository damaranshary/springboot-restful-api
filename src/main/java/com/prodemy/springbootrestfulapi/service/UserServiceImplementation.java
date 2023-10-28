package com.prodemy.springbootrestfulapi.service;

import com.prodemy.springbootrestfulapi.entity.User;
import com.prodemy.springbootrestfulapi.model.RegisterUserRequest;
import com.prodemy.springbootrestfulapi.model.UpdateUserRequest;
import com.prodemy.springbootrestfulapi.model.UserResponse;
import com.prodemy.springbootrestfulapi.repository.UserRepository;
import com.prodemy.springbootrestfulapi.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    @Transactional
    public void register(RegisterUserRequest request) {
       validationService.validate(request);

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Override
    public UserResponse getUser(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Override
    public UserResponse updateUser(User user, UpdateUserRequest request) {
        validationService.validate(request);

        if (Objects.nonNull(request.getName())) {
            user.setName(request.getName());
        }

        if (Objects.nonNull(request.getPassword())) {
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }

        userRepository.save(user);

        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .build();
    }

    @Override
    public Optional<User> findFirstByToken(String token) {
        return userRepository.findFirstByToken(token);
    }
}
