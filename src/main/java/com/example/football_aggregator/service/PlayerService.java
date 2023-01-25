package com.example.football_aggregator.service;

import com.example.football_aggregator.api_models.ResponsePlayer;
import com.example.football_aggregator.api_models.ResponseTeam;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface PlayerService {

    List<ResponsePlayer> findPlayer(Map<String,String> param);
}
