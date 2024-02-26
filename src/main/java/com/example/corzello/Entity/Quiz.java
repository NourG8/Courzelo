package com.example.corzello.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQuiz;

    @OneToMany(mappedBy = "quiz",cascade = CascadeType.ALL)
    private Set<reponses_etudiant> reponsesEtudiants;
    @OneToMany( mappedBy ="quiz" ,cascade = CascadeType.ALL)
    private Set<Question> questions;
    @OneToMany( mappedBy ="quiz" ,cascade = CascadeType.ALL)
    private Set<ModuleEntity> modules;



}
