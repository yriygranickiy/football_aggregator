package com.example.football_aggregator.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCommand {

    private Team team;

    private Venue venue;

}
