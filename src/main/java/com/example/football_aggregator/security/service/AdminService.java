package com.example.football_aggregator.security.service;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;

public interface AdminService {

    Privilege savePrivilege(Privilege privilegeName);

    Role saveRole(Role roleName);

    UserDto getUserById(Long id);

    UserDto updateUser(UserDto user, Long id);

}
