package com.example.football_aggregator.api;


import com.example.football_aggregator.entity.ResponseCommand;
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
public class ApiFootballClientImpl extends FootballApiClient {

    @Override
    public List<ResponseCommand> getTeam(Map<String,String> param){
        String result = "";
        String responseTeam = "";
        List<ResponseCommand> responseCommandList = new ArrayList<>();

        Request request = buildRequest("/teams"+ UtillitiesParam.buildQueryParam(param));

        try {
            Response response = client.newCall(request).execute();

            result = Objects.requireNonNull(response.body()).string();

            ObjectMapper mapper = new ObjectMapper();

            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode node = mapper.readTree(result);

            responseTeam = node.get("response").toString();

            responseCommandList = mapper.readValue(responseTeam, new TypeReference<List<ResponseCommand>>() {});

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

}
