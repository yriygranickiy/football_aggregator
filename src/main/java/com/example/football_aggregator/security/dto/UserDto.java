package com.example.football_aggregator.security.dto;

import com.example.football_aggregator.security.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private UUID id;

    private String firstname;

    private String lastname;

    private String email;

    private Collection<Role> role;
}
