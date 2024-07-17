package com.example.hexagonalarchitecture.infrastructure.adapters.output.persistence.repository;

import com.example.hexagonalarchitecture.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
