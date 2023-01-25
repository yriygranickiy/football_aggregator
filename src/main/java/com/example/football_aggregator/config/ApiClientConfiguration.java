package com.example.football_aggregator.config;

import com.example.football_aggregator.api.ApiFootballClientImpl;
import com.example.football_aggregator.api.TeamClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApiClientConfiguration {

    @Bean
    public TeamClient client(@Value("${api.football.scheme}") String scheme,
                             @Value("${api.football.host}") String host,
                             @Value("${api.football.key}") String apiKey){
        return ApiFootballClientImpl.builder()
                .scheme(scheme)
                .host(host)
                .apiKey(apiKey)
                .client(new OkHttpClient())
                .build();
    }

}
