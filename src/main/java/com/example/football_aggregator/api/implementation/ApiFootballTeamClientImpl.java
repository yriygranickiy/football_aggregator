package com.example.football_aggregator.api.implementation;


import com.example.football_aggregator.api.FootballApiClient;
import com.example.football_aggregator.entity.ApiFootballResponseApiTeam;
import com.example.football_aggregator.entity.ResponseApiTeam;
import com.example.football_aggregator.exception.ApiRequestException;
import com.example.football_aggregator.utill.UtillitiesParam;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.SuperBuilder;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@SuperBuilder
public class ApiFootballTeamClientImpl extends FootballApiClient {

    @Override
    public List<? extends ResponseApiTeam> getTeam(Map<String,String> param){

        String result = "";

        String responseTeam = "";

        List<ApiFootballResponseApiTeam> apiFootballResponseApiTeamList = new ArrayList<>();

        Request request = buildRequest("/teams"+ UtillitiesParam.buildQueryParam(param));

        try {
            Response response = client.newCall(request).execute();

            result = Objects.requireNonNull(response.body()).string();

            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode node = mapper.readTree(result);

            responseTeam = node.get("response").toString();

            apiFootballResponseApiTeamList = mapper.readValue(responseTeam, new TypeReference<List<ApiFootballResponseApiTeam>>() {});


            if(apiFootballResponseApiTeamList.isEmpty()){
                throw new ApiRequestException("this team not found");
            }else {
               return apiFootballResponseApiTeamList;
            }
        } catch (IOException e) {
           e.getMessage();
        }
        return apiFootballResponseApiTeamList;
    }

    protected Request buildRequest(String param) {
        return new Request
                .Builder()
                .url(buildUrl("v3")+param)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", host)
                .build();
    }


}
