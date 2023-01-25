package com.example.football_aggregator.api;


import com.example.football_aggregator.entity.TeamInfo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TeamClient {

     List<TeamInfo> getTeam(Map<String,String> param);

}
