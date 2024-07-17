package com.example.hexagonalarchitecture.application.ports.input;

import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;


public interface GetAllUsersUseCase {
    Collection<User> getAllUsers();
}
