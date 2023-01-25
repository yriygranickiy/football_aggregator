package com.example.football_aggregator.api;


import com.example.football_aggregator.api_models.ResponseTeam;
import com.example.football_aggregator.entity.TeamInfo;
import com.example.football_aggregator.exception.ApiRequestException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.SuperBuilder;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;


@SuperBuilder
public class ApiFootballClientImpl extends FootballApiClient {

    //"https://api-football-v1.p.rapidapi.com/v3/players/topscorers?league=39&season=2021"


    @Override
    public List<TeamInfo> getTeam(Map<String,String> param){
        String result = "";
        String responseTeam = "";
        List<TeamInfo> teamInfoList = new ArrayList<>();

        Request request = buildRequest("/teams"+ buildQueryParam(param));

        try {
            Response response = client.newCall(request).execute();

            result = Objects.requireNonNull(response.body()).string();

            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode node = mapper.readTree(result);

            responseTeam = node.get("response").toString();

            teamInfoList = mapper.readValue(responseTeam, new TypeReference<List<TeamInfo>>() {});

            if(teamInfoList.isEmpty()){
                throw new ApiRequestException("this team not found");
            }else {
               return teamInfoList;
            }
        } catch (IOException e) {
           e.getMessage();
        }
        return  teamInfoList;
    }

    private String buildQueryParam(Map<String,String> params){

        StringBuilder sb = new StringBuilder("?");

        params.forEach((k,v) -> sb.append(k).append("=").append(v).append("&"));

        return sb.toString();
    }
}
