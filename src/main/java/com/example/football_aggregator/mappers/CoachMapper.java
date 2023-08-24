package com.example.football_aggregator.mappers;


import com.example.football_aggregator.dto.CoachDto;
import com.example.football_aggregator.entity.ApiFootball.Coach;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CoachMapper {

    CoachMapper INSTANCE = Mappers.getMapper(CoachMapper.class);

    CoachDto convertCoachDto(Coach coach);
}
