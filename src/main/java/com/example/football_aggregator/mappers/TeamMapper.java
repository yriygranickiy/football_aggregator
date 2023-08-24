package com.example.football_aggregator.mappers;

import com.example.football_aggregator.dto.TeamDto;
import com.example.football_aggregator.entity.ApiFootball.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.ApiFootball.Team;
import com.example.football_aggregator.entity.FootballProResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;
import com.example.football_aggregator.dto.ResponseTeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeamMapper {

    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);


    TeamDto convertTeamDto(Team team);


//    ResponseTeamDto convertResponseDataTeam(FootballProResponseApiTeam footballProResponseApiTeam);



//
//    default ResponseTeamDto convertTeam(ResponseApiTeam team) {
//        if (team instanceof ApiFootballResponseApiTeam) {
//            return convertResponseTeam((ApiFootballResponseApiTeam) team);
//      }else if(team instanceof FootballProResponseApiTeam){
//            return convertResponseDataTeam((FootballProResponseApiTeam) team);
//        }
//        return null;
//    }
}
