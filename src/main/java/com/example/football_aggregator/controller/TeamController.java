package com.example.football_aggregator.controller;

import com.example.football_aggregator.dto.ResponseTeamDto;
import com.example.football_aggregator.mappers.FullResponseTeamMapper;
import com.example.football_aggregator.service.AggregatorTeamBuilder;
import com.example.football_aggregator.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class TeamController {

    private final TeamService topScorersService;

    private final AggregatorTeamBuilder teamBuilder;


    @GetMapping(("team-league"))
    public ResponseEntity<ResponseTeamDto> getTeamLeague(@RequestParam Map<String,String> allParam) {

        ResponseTeamDto response = teamBuilder.buildResponseTeam(topScorersService.getTeam(allParam));

        return new ResponseEntity<>(response, HttpStatus.OK);

    }














}
