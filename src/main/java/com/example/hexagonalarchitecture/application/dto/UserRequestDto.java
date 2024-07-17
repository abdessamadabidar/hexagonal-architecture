package com.example.hexagonalarchitecture.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String email;
}
