package com.example.football_aggregator.service;



import com.example.football_aggregator.api_models.ResponseTeam;
import com.example.football_aggregator.entity.TeamInfo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface TeamService {

    List<ResponseTeam> getTeam(Map<String,String> param);

}
