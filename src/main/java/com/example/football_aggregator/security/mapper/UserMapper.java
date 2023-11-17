package com.example.football_aggregator.security.mapper;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "role",expression = "java(user.getRoles())")
    UserDto mapToDto(User user);

    @InheritInverseConfiguration
    User map(UserDto userDto);
}
