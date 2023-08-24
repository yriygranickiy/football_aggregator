package com.example.football_aggregator.dto;

import com.example.football_aggregator.entity.ApiFootball.Birth;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoachDto {

    @JsonIgnore
    private Long id;

    private String name;

    private String firstname;

    private String lastname;

    private int age;

    private Birth birth;

    private String nationality;

}
