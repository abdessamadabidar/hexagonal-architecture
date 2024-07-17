package com.example.hexagonalarchitecture.infrastructure.adapters.output.persistence.mapper;

import com.example.hexagonalarchitecture.application.dto.UserRequestDto;
import com.example.hexagonalarchitecture.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User userRequestToUser(UserRequestDto userRequestDto);
}
