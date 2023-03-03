package com.example.football_aggregator.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballProResponseApiTeam implements ResponseApiTeam{

    private Long id;

    private String name;

    private String short_code;

    private int country_id;

    private boolean national_team;

    private int founded;

    @Override
    public String getTeamName() {
        return name;
    }

    @Override
    public int getTeamFounded() {
        return founded;
    }


}
