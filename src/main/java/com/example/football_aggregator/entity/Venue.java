package com.example.football_aggregator.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Venue {

    private String name;

    private String address;

    private String city;

    private int capacity;

}
