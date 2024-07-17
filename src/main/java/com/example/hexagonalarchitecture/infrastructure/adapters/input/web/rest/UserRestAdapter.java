package com.example.hexagonalarchitecture.infrastructure.adapters.input.web.rest;

import com.example.hexagonalarchitecture.application.dto.UserRequestDto;
import com.example.hexagonalarchitecture.application.ports.input.CreateUserUseCase;
import com.example.hexagonalarchitecture.application.ports.input.GetAllUsersUseCase;
import com.example.hexagonalarchitecture.application.ports.input.GetUserUseCase;
import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestAdapter {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetAllUsersUseCase getAllUsersUseCase;


    @Autowired
    public UserRestAdapter(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, GetAllUsersUseCase getAllUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.getAllUsersUseCase = getAllUsersUseCase;
    }

    @GetMapping("/")
    public Collection<User> getAllUsers() {
        return getAllUsersUseCase.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable UUID id) {
        return getUserUseCase.getUserById(id);
    }

    @PostMapping("/user/create")
    public User createNewUser(@RequestBody UserRequestDto request) {
        return createUserUseCase.createUser(request);
    }


}
