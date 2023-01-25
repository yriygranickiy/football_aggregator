package com.example.football_aggregator.api;


import lombok.experimental.SuperBuilder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;



@SuperBuilder
public abstract class FootballApiClient implements TeamClient {

   protected OkHttpClient client;

   protected String scheme;

   protected String host;

   protected String apiKey;

   protected HttpUrl buildUrl(){
      return buildUrl("");
   }

   protected HttpUrl buildUrl(String segment){
      return new HttpUrl.Builder()
              .scheme(scheme)
              .host(host)
              .addPathSegment(segment)
              .build();
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
