package com.example.football_aggregator.security.dto;

import com.example.football_aggregator.security.model.Role;
import lombok.Data;

import java.util.Collection;

@Data
public class UserDto {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private Collection<Role> role;
}
