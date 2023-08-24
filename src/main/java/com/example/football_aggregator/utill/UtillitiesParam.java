package com.example.football_aggregator.utill;

import java.util.Map;

public class UtillitiesParam {

    public static String buildQueryParam(Map<String,String> params){

        StringBuilder sb = new StringBuilder("?");

        params.forEach((k,v) -> sb.append(k).append("=").append(v).append("&"));

        return sb.toString();
    }

    public static String buildParam(Map<String,String> params){

        StringBuilder sb = new StringBuilder("/");


        params.forEach((k,v)-> sb.append(v));


        return sb.toString();
    }

    public static String buildParamById(String id,String include){

        StringBuilder sb = new StringBuilder("/");

        sb.append(id).append("?").append("include=").append(include);

        return sb.toString();
    }

    public static String buildQueryParamById(String id){

        StringBuilder sb = new StringBuilder("/");

        sb.append("coachs?").append("team=").append(id);

        return sb.toString();
    }

}
