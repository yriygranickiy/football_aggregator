package com.example.football_aggregator.service;


import com.example.football_aggregator.entity.*;
import com.example.football_aggregator.api.TeamClient;
import com.example.football_aggregator.dto.ResponseTeam;
import com.example.football_aggregator.mappers.FootballTeamMapper;
import com.example.football_aggregator.model.MatchTeamsId;
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

        Map<TeamKey,List<ResponseApiTeam>> hashMapTeam = new HashMap<>();

        for (TeamClient teamClient1 : teamClient) {
            List<? extends ResponseApiTeam> team = teamClient1.getTeam(param);
            collect.addAll(team);
        }

        hashMapTeam = matchTeam(collect);

        hashMapTeam.forEach(this::saveMatchedTeamsIdApi);


        List<ResponseTeam> responseTeams = collectResult.stream()
                  .map(FootballTeamMapper.INSTANCE::convertTeam)
                .collect(Collectors.toList());

        return responseTeams;

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

//        hashApiTeam.forEach((k,v)-> System.out.println("Key----->: " + k + " "+"value------->: "+v));

        return hashApiTeam;
    }

    private void saveMatchedTeamsIdApi(TeamKey teamKey, List<ResponseApiTeam> listResponseApiTeams){

        MatchTeamsId.MatchTeamsIdBuilder builder = MatchTeamsId.builder();

        for (ResponseApiTeam team:
             listResponseApiTeams) {
            if(team instanceof ApiFootballResponseApiTeam){
                builder.apiFootballResponseId(((ApiFootballResponseApiTeam) team).getTeam().getId());
            }else if(team instanceof FootballProResponseApiTeam){
                builder.footballProResponseId(((FootballProResponseApiTeam) team).getId());
            }
            builder.teamKey(teamKey);
        }

        MatchTeamsId matchTeamsId = builder.build();

        List<MatchTeamsId> responseApiTeamList = new ArrayList<>();

        if(matchTeamsId.getApiFootballResponseId() != null && matchTeamsId.getFootballProResponseId() != null){

            responseApiTeamList.add(matchTeamsId);

            System.out.println(responseApiTeamList);
        }
    }

}


