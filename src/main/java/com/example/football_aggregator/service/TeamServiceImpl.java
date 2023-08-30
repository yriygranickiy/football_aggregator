package com.example.football_aggregator.service;


import com.example.football_aggregator.entity.*;
import com.example.football_aggregator.api.TeamClient;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TeamServiceImpl implements TeamService {

    private final Set<TeamClient> teamClient;

    public TeamServiceImpl(Set<TeamClient> teamClient) {
        this.teamClient = teamClient;
    }

    public List<ResponseApiTeam> getTeam(Map<String,String> param){

        List<ResponseApiTeam> collect = new ArrayList<>();

        Map<TeamKey,List<ResponseApiTeam>> hashMapTeam = new HashMap<>();

        for (TeamClient teamClient1 : teamClient) {
            List<? extends ResponseApiTeam> team = teamClient1.getTeam(param);
            collect.addAll(team);
        }

        hashMapTeam = matchTeam(collect);

        return collect;

    }



    private Map<TeamKey,List<ResponseApiTeam>> matchTeam(List<ResponseApiTeam> listTeam){

        Map<TeamKey,List<ResponseApiTeam>> hashApiTeam = new HashMap<>();

        for (ResponseApiTeam responseApiTeam:
             listTeam) {

            TeamKey teamKey = responseApiTeam.getTeamKey();

            List<ResponseApiTeam> responseApiTeamList = hashApiTeam.putIfAbsent(teamKey,new ArrayList<>());

            if(Objects.isNull(responseApiTeamList)){
                hashApiTeam.get(teamKey).add(responseApiTeam);
            }else {
                responseApiTeamList.add(responseApiTeam);
            }
        }


        return hashApiTeam;
    }



}


