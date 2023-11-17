package com.example.football_aggregator.security.service;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.model.User;

import java.util.UUID;

public interface AdminService {

    Privilege savePrivilege(Privilege privilegeName);

    Role saveRole(Role roleName);

    UserDto getUserById(UUID id);

    UserDto updateUser(UserDto user, UUID id);

}
