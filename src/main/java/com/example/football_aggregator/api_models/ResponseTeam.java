package com.example.football_aggregator.api_models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ResponseTeam {

    private String name;

    private String country;

    private Stadium stadium;

}
