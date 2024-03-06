package com.example.corzello.Service;

import com.example.corzello.Controller.AuthenticationRequest;
import com.example.corzello.Controller.AuthenticationResponse;
import com.example.corzello.Controller.RegisterRequest;
import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;
import com.example.corzello.Repository.UserRepo;
import com.example.corzello.Security.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private JwtService jwtService ;
    @Autowired
    private AuthenticationManager authenticationManager ;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
       //TODo:RAJA3 ELROLE
        var user =UserEntity.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Role.ROLE_User)
                .build();
        userRepo.save(user) ;
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().user(user).token(jwtToken).build() ;
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user=userRepo.findByEmail(request.getEmail());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().user(user).token(jwtToken).build() ;
    }


    @Override
    public Role addRoletoUser(String email, String role) {
        UserEntity user = userRepo.findByEmail(email);
        Role role1 = Role.valueOf(role);
        try {user.setRoles(role1);}
        catch (Exception e){
            log.info(e.toString());
        }
        log.info("role added to user");
        return role1 ;
    }

    @Override
    public UserEntity getUserById(long idUser) {
        return userRepo.findById(idUser);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepo.findAll();
    }
}
