package com.example.football_aggregator.security.service;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.mapper.UserMapper;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.model.User;
import com.example.football_aggregator.security.repository.PrivilegeRepository;
import com.example.football_aggregator.security.repository.RoleRepository;
import com.example.football_aggregator.security.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImplAdminServiceTest {

    @InjectMocks
    ImplAdminService service;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PrivilegeRepository privilegeRepository;

    @Test
    void should_save_Privilege() {

        Privilege privilege = Privilege.builder()
                .name("READ_MANAGER")
                .build();
        when(privilegeRepository.save(privilege)).thenReturn(new Privilege(UUID.randomUUID(), "READ_MANAGER"));

        Privilege createdPrivilege = service.savePrivilege(privilege);

        assertNotNull(createdPrivilege);
        assertEquals("READ_MANAGER", createdPrivilege.getName());

    }

    @Test
    void should_save_Role() {

        Role roleToCreate = Role.builder()
                .name("MANAGER")
                .build();

        when(roleRepository.save(roleToCreate)).thenReturn(new Role(UUID.randomUUID(), "MANAGER", null));

        Role createdRole = service.saveRole(roleToCreate);

        assertNotNull(createdRole);
        assertEquals("MANAGER", createdRole.getName());
    }

    @Test
    void should_get_User_ById() {
        UUID id = UUID.randomUUID();
        User user = User.builder()
                .id(id)
                .email("hranitskyi@gmail.com")
                .firstname("Yurii")
                .lastname("Hranitskyi")
                .roles(Stream.of(Role.builder().name("ADMIN").build()).collect(Collectors.toList()))
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        UserDto userDto = service.getUserById(id);


        assertNotNull(user);
        assertEquals("hranitskyi@gmail.com", userDto.getEmail());
        assertEquals("Yurii", userDto.getFirstname());
        assertEquals("Hranitskyi",userDto.getLastname());
    }

    @Test
    void should_update_User() {
        UUID id = UUID.randomUUID();

        User existingUser = User.builder()
                .id(id)
                .email("hranitskyi@gmail.com")
                .firstname("Yurii")
                .lastname("Hranitskyi")
                .roles(Stream.of(Role.builder().name("ADMIN").build()).collect(Collectors.toList()))
                .build();

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));

        UserDto updateUser = UserDto.builder()
                .id(id)
                .email("hranitskyi98@gmail.com")
                .firstname("Yurii")
                .lastname("Hranitskyi")
                .role(Stream.of(Role.builder().name("ADMIN").build()).collect(Collectors.toList()))
                .build();

        UserDto userDtoResult = service.updateUser(updateUser, updateUser.getId());

        assertNotNull(userDtoResult);
        assertEquals("hranitskyi98@gmail.com",userDtoResult.getEmail());
        assertEquals("Yurii",userDtoResult.getFirstname());

    }
}