package com.example.football_aggregator.api.implementation;


import com.example.football_aggregator.api.FootballApiClient;
import com.example.football_aggregator.entity.FootballProResponseApiTeam;
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
public  class FootballProTeamClientImpl  extends FootballApiClient {

    String path = "/Users/urijgranickij/Downloads/football_aggregator/src/main/java/com/example/football_aggregator";

    @Override
    public List<? extends ResponseApiTeam> getTeam(Map<String,String> param){

        String result = "";

        String responseList = "";

        List<FootballProResponseApiTeam> responseCommandList = new ArrayList<>();

//        Request request = buildRequest("/teams/search"+ UtillitiesParam
//                .buildParam(param));

        Request request = buildRequest("/teams/search"+ UtillitiesParam
                .buildParam(param));

        try {
            Response response = client.newCall(request).execute();

            result = Objects.requireNonNull(response.body()).string();

            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode node = mapper.readTree(result);

            responseList = node.path("data").toString();

            responseCommandList = mapper.readValue(responseList, new TypeReference<List<FootballProResponseApiTeam>>() {});
//            responseCommandList = mapper.readValue(responseList, new TypeReference<List<ResponseDataTeam>>() {});

            if(responseCommandList.isEmpty()){
                throw new ApiRequestException("this team not found");
            }else {
                return responseCommandList;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return responseCommandList;
    }


    protected Request buildRequest(String param) {
        return new Request
                .Builder()
                .url(buildUrl("api","v2.0")+param)
                .get()
                .addHeader("X-RapidAPI-Key", apiKey)
                .addHeader("X-RapidAPI-Host", host)
                .build();
    }


}
