package com.example.football_aggregator.security.jwt;

import com.example.football_aggregator.security.dto.auth.AuthenticationRequest;
import com.example.football_aggregator.security.dto.auth.AuthenticationResponse;
import com.example.football_aggregator.security.dto.auth.RegisterRequest;
import com.example.football_aggregator.security.dto.auth.RegisterResponse;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.model.User;
import com.example.football_aggregator.security.repository.RoleRepository;
import com.example.football_aggregator.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtAuthenticationService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authManager;


    @Transactional
    public RegisterResponse register(RegisterRequest request){
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roleRepository.findByName("USER"))
                .build();

        userRepository.save(user);

        String jwtToken = jwtService.generateToken(user);

        return RegisterResponse.builder()
                .name(user.getEmail())
                .token(jwtToken)
                .data(new Date())
                .build();
    }


    @Transactional
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );

        User user = userRepository.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("this email not found"));

        String jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .name(user.getEmail())
                .date(new Date())
                .token(jwtToken)
                .role(user.getRoles().stream().map(Role::getName).findAny().orElse("Not found"))
                .build();
    }
}
