package com.example.corzello.Repository;

import com.example.corzello.Entity.ModuleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleRepository extends CrudRepository<ModuleEntity, Long> {

    @Override
    Optional<ModuleEntity> findById(Long IdProg);
}
