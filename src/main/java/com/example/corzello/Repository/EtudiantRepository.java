package com.example.corzello.Repository;
import com.example.corzello.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository  extends JpaRepository<Etudiant,Long>{
}