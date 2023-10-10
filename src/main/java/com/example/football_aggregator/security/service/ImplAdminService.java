package com.example.football_aggregator.security.service;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.mapper.UserMapper;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.model.User;
import com.example.football_aggregator.security.repository.PrivilegeRepository;
import com.example.football_aggregator.security.repository.RoleRepository;
import com.example.football_aggregator.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImplAdminService implements AdminService{

    private final PrivilegeRepository privilegeRepository;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    @Override
    public Privilege savePrivilege(Privilege privilegeName) {

        Privilege privilege = Privilege.builder()
                .name(privilegeName.getName())
                .build();

        return privilegeRepository.save(privilege);
    }

    @Override
    public Role saveRole(Role roleName) {
        Role role = Role.builder()
                .name(roleName.getName())
                .build();
        return roleRepository.save(role);
    }

    @Override
    public UserDto getUserById(Long id) {
        return userMapper.map(userRepository.findById(id)
                .orElseThrow(()-> new UsernameNotFoundException("not found user!")));
    }

    @Override
    public UserDto updateUser(UserDto user, Long id) {
        //find user
        User user1 = userRepository.findById(id).orElseThrow(()
                -> new UsernameNotFoundException("not found"));

        //update user
        user1.setEmail(user.getEmail());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setRoles(user.getRole());

        userRepository.save(user1);
        //convert to dto and return
        return userMapper.map(user1);

    }


}
