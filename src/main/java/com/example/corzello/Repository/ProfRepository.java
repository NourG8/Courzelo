package com.example.corzello.Repository;

import com.example.corzello.Entity.Etudiant;
import com.example.corzello.Entity.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProfRepository extends JpaRepository<Prof,Long> {
}
