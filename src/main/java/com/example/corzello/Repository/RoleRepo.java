package com.example.corzello.Repository;

import com.example.corzello.Entity.Role;
import com.example.corzello.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name) ;
}
