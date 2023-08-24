package com.example.football_aggregator.service;

import com.example.football_aggregator.api.TeamClient;
import com.example.football_aggregator.api.implementation.ApiFootballTeamClientImpl;
import com.example.football_aggregator.dto.ResponseTeamDto;
import com.example.football_aggregator.entity.ApiFootball.Coach;
import com.example.football_aggregator.entity.ApiFootball.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.FootballProResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;
import com.example.football_aggregator.mappers.CoachMapper;
import com.example.football_aggregator.mappers.StadiumMapper;
import com.example.football_aggregator.mappers.TeamMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AggregatorTeamBuilder {

    private TeamClient clientTeamPro;

    public ResponseTeamDto buildResponseTeam(List<ResponseApiTeam> responseApiTeamList){

        ResponseTeamDto responseTeamDto = new ResponseTeamDto();

        for (ResponseApiTeam responseApiTeam:responseApiTeamList){
            switch (responseApiTeam){
                case ApiFootballResponseApiTeam team -> apiFootballMapper(responseTeamDto,team);
//                case FootballProResponseApiTeam team -> apiFootballProMapper(responseTeamDto,team);
                default -> throw new IllegalStateException("Unexpected value: " + responseApiTeam);
            }
        }
        return responseTeamDto;
    }

    private void apiFootballMapper(ResponseTeamDto responseTeamDto, ApiFootballResponseApiTeam apiTeam){

        if(Objects.isNull(responseTeamDto.getTeamDto())){
            responseTeamDto.setTeamDto(TeamMapper.INSTANCE.convertTeamDto(apiTeam.getTeam()));
        }

        if (Objects.isNull(responseTeamDto.getStadiumDto())){
            responseTeamDto.setStadiumDto(StadiumMapper.INSTANCE.convertStadiumDto(apiTeam.getVenue()));
        }

        if (Objects.isNull(responseTeamDto.getCoachDto())){

          List<Coach> coachList = ((ApiFootballTeamClientImpl) clientTeamPro).getCoach(apiTeam.getIdTeam().toString());

          responseTeamDto.setCoachDto(CoachMapper.INSTANCE.convertCoachDto(coachList.get(0)));

        }
    }

    private void apiFootballProMapper(ResponseTeamDto responseTeamDto, FootballProResponseApiTeam apiTeam){
//        if(Objects.isNull(responseTeamDto.getName())){
//            responseTeamDto.setName(apiTeam.getName());
//        }
//        if (Objects.isNull(responseTeam.getCoach())){
//            ((FootballProTeamClientImpl) clientTeamPro).getById(apiTeam.getIdTeam().toString(),"coach");
//        }
    }
}
