package com.example.football_aggregator.security.service;

import com.example.football_aggregator.exception.ApiRequestException;
import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.mapper.UserMapper;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.model.User;
import com.example.football_aggregator.security.repository.PrivilegeRepository;
import com.example.football_aggregator.security.repository.RoleRepository;
import com.example.football_aggregator.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.webjars.NotFoundException;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
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
    void should_save_privilege() {

        Privilege privilege = Privilege.builder()
                .name("READ_MANAGER")
                .build();
        when(privilegeRepository.save(privilege)).thenReturn(new Privilege(UUID.randomUUID(), "READ_MANAGER"));

        Privilege createdPrivilege = service.savePrivilege(privilege);

        assertNotNull(createdPrivilege);
        assertEquals("READ_MANAGER", createdPrivilege.getName());

    }

    @Test
    void should_exist_privilege_and_get_exception(){
        Privilege privilege = Privilege.builder()
                .name("READ_MANAGER")
                .build();

        given(privilegeRepository.existsByName(privilege.getName())).willReturn(true);

        assertThatThrownBy(()->service.savePrivilege(privilege))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Privilege this name: "+privilege.getName()+" is exist");
    }

    @Test
    void should_save_role() {

        Role roleToCreate = Role.builder()
                .name("MANAGER")
                .build();

        when(roleRepository.save(roleToCreate)).thenReturn(new Role(UUID.randomUUID(), "MANAGER", null));

        Role createdRole = service.saveRole(roleToCreate);

        assertNotNull(createdRole);
        assertEquals("MANAGER", createdRole.getName());
    }



    @Test
    void should_exist_role_and_get_exception(){
        Role roleCreate = Role.builder()
                .name("MANAGER")
                .build();

        given(roleRepository.existsByName(roleCreate.getName())).willReturn(true);

        assertThatThrownBy(()->service.saveRole(roleCreate))
                .isInstanceOf(ApiRequestException.class)
                        .hasMessageContaining("This role "+roleCreate.getName()+" is exist");
    }

    @Test
    void should_get_user_by_id() {
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
        assertEquals("Hranitskyi", userDto.getLastname());
    }

//    @Test
//    void should_get_exception_if_user_not_found() {
//
//        when(userRepository.findById(UUID.randomUUID())).thenReturn(null);
//
//        assertThrows(ApiRequestException.class, ()->{
//            service.getUserById(UUID.randomUUID());
//        });
//    }

    @Test
    void should_update_user() {
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
        assertEquals("hranitskyi98@gmail.com", userDtoResult.getEmail());
        assertEquals("Yurii", userDtoResult.getFirstname());

    }
}