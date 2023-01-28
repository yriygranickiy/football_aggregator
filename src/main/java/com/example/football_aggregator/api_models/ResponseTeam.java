package com.example.football_aggregator.api_models;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeam {

    private String name;

    private String country;

    private Stadium stadium;

}
