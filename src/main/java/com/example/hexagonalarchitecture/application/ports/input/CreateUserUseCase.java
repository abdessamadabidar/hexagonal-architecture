package com.example.hexagonalarchitecture.application.ports.input;

import com.example.hexagonalarchitecture.application.dto.UserRequestDto;
import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.stereotype.Component;

public interface CreateUserUseCase {
    User createUser(UserRequestDto user);
}
