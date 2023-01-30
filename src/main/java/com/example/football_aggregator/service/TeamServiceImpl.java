package com.example.football_aggregator.service;


import com.example.football_aggregator.api.TeamClient;
import com.example.football_aggregator.api_models.ResponseTeam;
import com.example.football_aggregator.entity.ResponseCommand;
import com.example.football_aggregator.mappers.FootballTeamMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TeamServiceImpl implements TeamService {


    private final Set<TeamClient> teamClient;

    public TeamServiceImpl(Set<TeamClient> teamClient) {

        this.teamClient = teamClient;

    }

    public List<ResponseTeam> getTeam(Map<String,String> param){

        List<ResponseCommand> collect = new ArrayList<>();


        for (TeamClient teamClient1 : teamClient) {
            List<ResponseCommand> team = teamClient1.getTeam(param);
            collect.addAll(team);
        }

        List<ResponseTeam> responseTeams = collect.stream()
                .map(FootballTeamMapper.INSTANCE::convertTeam)
                .collect(Collectors.toList());
        
        return responseTeams;

    }

}
