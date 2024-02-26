package com.example.corzello.Repository;

import com.example.corzello.Entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iclassrepo extends JpaRepository<Classe,Integer> {
}