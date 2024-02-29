package com.example.corzello.Service;

import com.example.corzello.Controller.AuthenticationRequest;
import com.example.corzello.Controller.AuthenticationResponse;
import com.example.corzello.Controller.RegisterRequest;
import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;

import java.util.List;

public interface UserService {

    AuthenticationResponse register(RegisterRequest request) ;
    AuthenticationResponse authenticate(AuthenticationRequest request) ;
    Role saveRole(Role role) ;
    Role addRoletoUser(String email , String rolename);
    UserEntity getUserById (long idUser) ;
    List<UserEntity> getUsers() ;
    List<Role> getAllRoles();
    String deleteUser(long idUser);
}
