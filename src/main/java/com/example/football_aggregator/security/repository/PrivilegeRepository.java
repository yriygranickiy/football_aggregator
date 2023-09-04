package com.example.football_aggregator.security.repository;

import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long>{

   Collection<Privilege> findByName(String name);
}
