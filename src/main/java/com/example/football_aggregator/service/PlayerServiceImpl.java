package com.example.football_aggregator.service;

import com.example.football_aggregator.api_models.ResponsePlayer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService{


    @Override
    public List<ResponsePlayer> findPlayer(Map<String, String> param) {
        return null;
    }


}
