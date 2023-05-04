package com.example.football_aggregator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stadium {

    private String name;

    private String address;

    private String city;

    private int capacity;
}