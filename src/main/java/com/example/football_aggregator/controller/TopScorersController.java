package com.example.football_aggregator.controller;

import com.example.football_aggregator.api_models.ResponsePlayer;
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
public class TopScorersController {

    private final TeamService topScorersService;

    private final PlayerService playerService;


    public TopScorersController(TeamService topScorersService, PlayerService playerService) {
        this.topScorersService = topScorersService;
        this.playerService = playerService;
    }

    @GetMapping(value = ("/team-league/{id}"))
    public ResponseEntity<List<ResponseTeam>> getTeamLeague(@PathVariable("id") String id) {

        Map<String, String> params = new HashMap<>();

        params.put("id", id);

        List<ResponseTeam> respone =  topScorersService.getTeam(params);

        return new ResponseEntity<>(respone,HttpStatus.OK);


    }

//
//    @GetMapping(value = ("/player"))
//    public ResponseEntity<Object> searchPlayer(@RequestParam ResponsePlayer responsePlayer) {
//
//        return new ResponseEntity<>(playerService.findPlayer(),HttpStatus.OK);
//
//
//    }

}
