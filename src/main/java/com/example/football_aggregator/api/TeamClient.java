package com.example.football_aggregator.api;


import com.example.football_aggregator.entity.ResponseApiTeam;

import java.util.List;
import java.util.Map;
/*
this interface provide contract for getting information about team
 */
public interface TeamClient {

     List<? extends ResponseApiTeam> getTeam(Map<String,String> param);

}
