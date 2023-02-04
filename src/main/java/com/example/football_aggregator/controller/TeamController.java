package com.example.football_aggregator.controller;

import com.example.football_aggregator.api_models.ResponseTeam;
import com.example.football_aggregator.service.PlayerService;
import com.example.football_aggregator.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TeamController {

    private final TeamService topScorersService;

    private final PlayerService playerService;


    public TeamController(TeamService topScorersService, PlayerService playerService) {
        this.topScorersService = topScorersService;
        this.playerService = playerService;
    }

    @GetMapping(("/team-league"))
    public ResponseEntity<List<ResponseTeam>> getTeamLeague(@RequestParam Map<String,String> allParam) {

        List<ResponseTeam> response = topScorersService.getTeam(allParam);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }












}
