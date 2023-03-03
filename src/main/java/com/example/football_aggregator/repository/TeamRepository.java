package com.example.football_aggregator.repository;

import com.example.football_aggregator.model.ApiCompare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<ApiCompare,Long> {
}
