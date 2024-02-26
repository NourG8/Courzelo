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
public class   Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    private String nom;
    @ManyToOne(cascade = CascadeType.ALL)
    private Classe classe;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Compte_rendu> compteRendus;
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<reponses_etudiant> reponsesEtudiants;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private Set<Recruitement_çprocess_details> recruitementprocessDetails;

}


