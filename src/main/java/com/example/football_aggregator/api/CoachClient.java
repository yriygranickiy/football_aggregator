package com.example.football_aggregator.api;

import com.example.football_aggregator.entity.ApiFootball.Coach;

import java.util.List;

public interface CoachClient {

    List<Coach> getCoach(String id);
}
