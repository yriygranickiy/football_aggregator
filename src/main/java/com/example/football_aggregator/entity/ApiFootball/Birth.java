package com.example.football_aggregator.entity.ApiFootball;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Birth {

    private String date;

    private String place;

    private String country;
}
