package com.example.football_aggregator.mappers;

import com.example.football_aggregator.dto.StadiumDto;
import com.example.football_aggregator.entity.ApiFootball.Venue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StadiumMapper {

    StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

    StadiumDto convertStadiumDto(Venue venue);
}
