package com.example.corzello.Entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCours;
    @ManyToOne(cascade = CascadeType.ALL)
    private ModuleEntity module;
    @ManyToOne(cascade = CascadeType.ALL)
    private Compte_rendu compteRendu;
    @ManyToOne(cascade = CascadeType.ALL)
    private Prog_educatif progEducatif;


}
