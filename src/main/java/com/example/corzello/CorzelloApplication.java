package com.example.corzello;

import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;
import com.example.corzello.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootApplication
public class CorzelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorzelloApplication.class, args);
    }

    /*@Bean
    CommandLineRunner run (UserService userService){
        return  args -> {
          userService.saveRole(new Role(1,"Admin"));
          userService.saveRole(new Role(2,"Universite"));
          userService.saveRole(new Role(3,"Prof"));
          userService.saveRole(new Role(4,"Recruteur"));
          userService.saveRole(new Role(5,"Etudiant"));
          userService.saveRole(new Role(6,"default"));
        };
    }*/
}
