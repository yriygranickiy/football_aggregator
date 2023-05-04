package com.example.football_aggregator.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeam {

    private Long id;

    private String name;

    private String country;

    private int founded;

    private Stadium stadium;

}
