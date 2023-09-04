package com.example.football_aggregator.security.repository;

import com.example.football_aggregator.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Collection<Role> findByName(String name);
}
