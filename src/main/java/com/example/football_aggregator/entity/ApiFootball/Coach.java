package com.example.football_aggregator.entity.ApiFootball;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach {

    private Long id;

    private String name;

    private String firstname;

    private String lastname;

    private int age;

    private Birth birth;

    private String nationality;

}
