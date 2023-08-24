package com.example.football_aggregator.mappers;

import com.example.football_aggregator.dto.ResponseTeamDto;
import com.example.football_aggregator.entity.ApiFootball.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface FullResponseTeamMapper {

    FullResponseTeamMapper INSTANCE = Mappers.getMapper(FullResponseTeamMapper.class);

    ResponseTeamDto convertResponseTeamDto(ResponseApiTeam apiTeam);
}
