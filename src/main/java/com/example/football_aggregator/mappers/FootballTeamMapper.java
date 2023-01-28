package com.example.football_aggregator.mappers;

import com.example.football_aggregator.api_models.ResponseTeam;
import com.example.football_aggregator.entity.ResponseCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FootballTeamMapper {

    FootballTeamMapper INSTANCE = Mappers.getMapper(FootballTeamMapper.class);


    @Mapping(target = "name", expression = "java(responseCommand.getTeam().getName())")
    @Mapping(target = "country", expression = "java(responseCommand.getTeam().getCountry())")
    @Mapping(target = "stadium.name", expression = "java(responseCommand.getVenue().getName())")
    @Mapping(target = "stadium.address", expression = "java(responseCommand.getVenue().getAddress())")
    @Mapping(target = "stadium.city", expression = "java(responseCommand.getVenue().getCity())")
    @Mapping(target = "stadium.capacity", expression = "java(responseCommand.getVenue().getCapacity())")
    List<ResponseTeam> convertTeam(List<ResponseCommand> responseCommand);

}
