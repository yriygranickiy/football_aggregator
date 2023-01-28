package com.example.football_aggregator.api;


import com.example.football_aggregator.entity.ResponseCommand;

import java.util.List;
import java.util.Map;

public interface TeamClient {

     List<ResponseCommand> getTeam(Map<String,String> param);

}
