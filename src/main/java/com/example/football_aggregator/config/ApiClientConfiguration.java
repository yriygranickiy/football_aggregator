package com.example.football_aggregator.config;

import com.example.football_aggregator.api.implementation.ApiFootballTeamClientImpl;
import com.example.football_aggregator.api.TeamClient;
//import com.example.football_aggregator.api.implementation.FootballProTeamClientImpl;
import com.example.football_aggregator.api.implementation.FootballProTeamClientImpl;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiClientConfiguration {

    @Bean
    public TeamClient clientTeam(@Value("${api.football.scheme}") String scheme,
                             @Value("${api.football.host}") String host,
                             @Value("${api.football.key}") String apiKey){
        return ApiFootballTeamClientImpl.builder()
                .scheme(scheme)
                .host(host)
                .apiKey(apiKey)
                .client(new OkHttpClient())
                .build();
    }


    @Bean
    public TeamClient clientTeamPro(@Value("${api.football.scheme}") String scheme,
                             @Value("${api.football-pro.host}") String host,
                             @Value("${api.football.key}") String apiKey){
        return FootballProTeamClientImpl.builder()
                .scheme(scheme)
                .host(host)
                .apiKey(apiKey)
                .client(new OkHttpClient())
                .build();
    }

}
