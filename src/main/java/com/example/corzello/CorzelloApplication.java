package com.example.corzello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
