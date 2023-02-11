package com.example.football_aggregator.utill;

import java.util.Map;

public class UtillitiesParam {

    public static String buildQueryParam(Map<String,String> params){

        StringBuilder sb = new StringBuilder("?");

        params.forEach((k,v) -> sb.append(k).append("=").append(v).append("&"));

        return sb.toString();
    }
}
