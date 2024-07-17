package com.example.hexagonalarchitecture.application.ports.output;

import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface UserOutputPort {
    User saveUser(User user);
    Optional<User> getUserById(UUID id);
    Optional<User> getUserByEmail(String email);
    Collection<User> getAllUsers();

}
