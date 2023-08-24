package com.example.football_aggregator.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeamDto {

    @JsonProperty("Team")
    private TeamDto teamDto;

    @JsonProperty("Stadium")
    private StadiumDto stadiumDto;

    @JsonProperty("Coach")
    private CoachDto coachDto;
}
