package com.example.football_aggregator.service;



import com.example.football_aggregator.dto.ResponseTeamDto;
import com.example.football_aggregator.entity.ApiFootball.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;

import java.util.List;
import java.util.Map;


public interface TeamService {

    List<ResponseApiTeam> getTeam(Map<String,String> param);

}
