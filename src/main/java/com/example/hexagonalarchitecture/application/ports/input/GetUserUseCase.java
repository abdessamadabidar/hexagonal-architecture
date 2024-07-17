package com.example.hexagonalarchitecture.application.ports.input;

import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

public interface GetUserUseCase {
    User getUserById(UUID id);
}
