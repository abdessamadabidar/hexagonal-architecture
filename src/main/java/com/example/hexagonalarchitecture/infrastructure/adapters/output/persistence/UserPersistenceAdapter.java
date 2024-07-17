package com.example.hexagonalarchitecture.infrastructure.adapters.output.persistence;

import com.example.hexagonalarchitecture.application.ports.output.UserOutputPort;
import com.example.hexagonalarchitecture.domain.model.User;
import com.example.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

// UserPersistenceAdapter it is an output adapter

@Component
public class UserPersistenceAdapter implements UserOutputPort {

    private final UserJpaRepository userJpaRepository;

    @Autowired
    public UserPersistenceAdapter(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @Override
    public User saveUser(User user) {
        return userJpaRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(UUID id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userJpaRepository.findAll();
    }
}
