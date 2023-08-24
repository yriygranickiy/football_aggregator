package com.example.football_aggregator.entity.ApiFootball;


import com.example.football_aggregator.entity.ResponseApiTeam;
import com.example.football_aggregator.entity.TeamKey;
import lombok.*;

@Data
@NoArgsConstructor
public class ApiFootballResponseApiTeam implements ResponseApiTeam {

    private Team team;

    private Venue venue;

    private Coach coach;

    @Override
    public String getTeamName() {
        return team.getName();
    }

    @Override
    public int getTeamFounded() {
        return team.getFounded();
    }

    @Override
    public TeamKey getTeamKey() {
        return new TeamKey(team.getName(),team.getFounded());
    }

    @Override
    public Long getIdTeam() {
        return team.getId();
    }
}
