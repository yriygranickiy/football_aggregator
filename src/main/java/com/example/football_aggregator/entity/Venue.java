package com.example.football_aggregator.entity;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {

    private String name;

    private String address;

    private String city;

    private int capacity;

}
