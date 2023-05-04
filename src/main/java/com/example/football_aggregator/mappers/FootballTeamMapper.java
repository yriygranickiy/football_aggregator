package com.example.football_aggregator.mappers;

import com.example.football_aggregator.entity.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.FootballProResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;
import com.example.football_aggregator.dto.ResponseTeam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FootballTeamMapper {

    FootballTeamMapper INSTANCE = Mappers.getMapper(FootballTeamMapper.class);


    @Mapping(target = "id",expression = "java(apiFootballResponseApiTeam.getTeam().getId())")
    @Mapping(target = "name", expression = "java(apiFootballResponseApiTeam.getTeam().getName())")
    @Mapping(target = "country", expression = "java(apiFootballResponseApiTeam.getTeam().getCountry())")
    @Mapping(target = "founded", expression = "java(apiFootballResponseApiTeam.getTeam().getFounded())")
    @Mapping(target = "stadium.name", expression = "java(apiFootballResponseApiTeam.getVenue().getName())")
    @Mapping(target = "stadium.address", expression = "java(apiFootballResponseApiTeam.getVenue().getAddress())")
    @Mapping(target = "stadium.city", expression = "java(apiFootballResponseApiTeam.getVenue().getCity())")
    @Mapping(target = "stadium.capacity", expression = "java(apiFootballResponseApiTeam.getVenue().getCapacity())")
    ResponseTeam convertResponseTeam(ApiFootballResponseApiTeam apiFootballResponseApiTeam);



    ResponseTeam convertResponseDataTeam(FootballProResponseApiTeam footballProResponseApiTeam);

    default ResponseTeam convertTeam(ResponseApiTeam team) {
        if (team instanceof ApiFootballResponseApiTeam) {
            return convertResponseTeam((ApiFootballResponseApiTeam) team);
      }else if(team instanceof FootballProResponseApiTeam){
            return convertResponseDataTeam((FootballProResponseApiTeam) team);
        }
        return null;
    }
}
