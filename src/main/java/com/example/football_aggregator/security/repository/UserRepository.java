package com.example.football_aggregator.security.repository;

import com.example.football_aggregator.security.model.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail (String email);


    Optional<User> findById(UUID id);
}
