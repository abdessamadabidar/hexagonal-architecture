package com.example.hexagonalarchitecture.infrastructure.adapters.input.web.graphql;

import com.example.hexagonalarchitecture.application.ports.input.GetAllUsersUseCase;
import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class UserGraphqlAdapter {

    private final GetAllUsersUseCase getAllUsersUseCase;

    @Autowired
    public UserGraphqlAdapter(GetAllUsersUseCase getAllUsersUseCase) {
        this.getAllUsersUseCase = getAllUsersUseCase;
    }


    @QueryMapping
    public Collection<User> users() {
        return getAllUsersUseCase.getAllUsers();
    }


}
