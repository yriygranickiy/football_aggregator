package com.example.football_aggregator.security.mapper;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role",expression = "java(user.getRoles())")
    UserDto map(User user);

    @InheritInverseConfiguration
    User map(UserDto userDto);
}
