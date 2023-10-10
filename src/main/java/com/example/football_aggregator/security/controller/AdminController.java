package com.example.football_aggregator.security.controller;

import com.example.football_aggregator.security.dto.UserDto;
import com.example.football_aggregator.security.model.Privilege;
import com.example.football_aggregator.security.model.Role;
import com.example.football_aggregator.security.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    private final AdminService adminService;


    @PreAuthorize("hasAuthority('WRITE_ADMIN')")
    @PostMapping("/save-privilege")
    public ResponseEntity<Privilege> saveEmployee(@RequestBody Privilege privilegeName){
        return new ResponseEntity<>(adminService.savePrivilege(privilegeName), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('WRITE_ADMIN')")
    @PostMapping("/save-role")
    public ResponseEntity<Role> saveRole(@RequestBody Role roleName){
        return new ResponseEntity<>(adminService.saveRole(roleName),HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('READ_ADMIN')")
    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserById(@RequestParam(name = "id") Long id){
        return new ResponseEntity<>(adminService.getUserById(id),HttpStatus.OK);
    }


    @PreAuthorize("hasAuthority('UPDATE_USER')")
    @PutMapping("/update-user")
    public ResponseEntity<UserDto> updateUser
            (@RequestBody UserDto user,@RequestParam(name="id") Long id){
        return new ResponseEntity<>(adminService.updateUser(user,id),HttpStatus.OK);
    }
}
