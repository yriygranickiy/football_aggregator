package com.example.football_aggregator.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiFootballResponseApiTeam implements ResponseApiTeam{

    private Team team;

    private Venue venue;

    @Override
    public String getTeamName() {
        return team.getName();
    }

    @Override
    public int getTeamFounded() {
        return team.getFounded();
    }
}
