package com.example.hexagonalarchitecture.domain.service;


import com.example.hexagonalarchitecture.application.dto.UserRequestDto;
import com.example.hexagonalarchitecture.application.ports.input.CreateUserUseCase;
import com.example.hexagonalarchitecture.application.ports.input.GetAllUsersUseCase;
import com.example.hexagonalarchitecture.application.ports.input.GetUserUseCase;
import com.example.hexagonalarchitecture.application.ports.output.UserOutputPort;
import com.example.hexagonalarchitecture.domain.exception.UserAlreadyRegisteredException;
import com.example.hexagonalarchitecture.domain.exception.UserNotFoundException;
import com.example.hexagonalarchitecture.domain.model.User;
import com.example.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements CreateUserUseCase, GetUserUseCase, GetAllUsersUseCase {

    private final UserOutputPort userOutputPort;
    private final IUserMapper mapper;

    @Autowired
    public UserServiceImpl(UserOutputPort userOutputPort, IUserMapper mapper) {
        this.userOutputPort = userOutputPort;
        this.mapper = mapper;
    }


    @Override
    public User createUser(UserRequestDto user) {

        // check whether the user is already exist or not
        Optional<User> optionalUser =  userOutputPort.getUserByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new UserAlreadyRegisteredException(
                    String.format("User with email %s already exist!", user.getEmail())
            );
        }


        // map UserRequest to User
        User newUser = mapper.userRequestToUser(user);
        return userOutputPort.saveUser(newUser);
    }

    @Override
    public User getUserById(UUID id) {
        return userOutputPort
                .getUserById(id)
                .orElseThrow(
                        () -> new UserNotFoundException(
                                String.format("user with ID %s does not exist", id)
                        )
                );
    }

    @Override
    public Collection<User> getAllUsers() {
        return userOutputPort.getAllUsers();
    }
}
