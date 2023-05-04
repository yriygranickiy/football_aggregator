package com.example.football_aggregator.service;


import com.example.football_aggregator.entity.*;
import com.example.football_aggregator.api.TeamClient;
import com.example.football_aggregator.dto.ResponseTeam;
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

        List<ResponseApiTeam> collect = new ArrayList<>();

        List<? extends ResponseApiTeam> collectResult = new ArrayList<>();


        for (TeamClient teamClient1 : teamClient) {
            List<? extends ResponseApiTeam> team = teamClient1.getTeam(param);
            collect.addAll(team);
            collectResult = getTeamCompare(collect);
        }


        List<ResponseTeam> responseTeams = collectResult.stream()
                  .map(FootballTeamMapper.INSTANCE::convertTeam)
                .collect(Collectors.toList());

        return responseTeams;

    }


    private List<? extends ResponseApiTeam> getTeamCompare(List<? extends ResponseApiTeam> list){

        List<ResponseApiTeam> responseApiTeams = new ArrayList<>();

        for (int i = 0; i<list.size();i++){
            for (int j = i+1; j<list.size();j++){
                if(list.get(i).getTeamFounded() == list.get(j).getTeamFounded() &&
                        list.get(i).getTeamName().equals(list.get(j).getTeamName())&&
                        list.get(i).getTeamFounded() != 0 &&
                        list.get(j).getTeamFounded() != 0){
                    responseApiTeams.add(list.get(i));
                    responseApiTeams.add(list.get(j));
                }
            }
        }

        return responseApiTeams;
    }

}


