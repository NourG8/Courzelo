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
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClasse;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Emploi_Du_Temps> emploi_Du_Temps;
    @ManyToMany(mappedBy = "classes",cascade = CascadeType.ALL)
    private Set<Prof> profs;
    @OneToMany(mappedBy ="classe"  ,cascade = CascadeType.ALL)
    private Set<Etudiant>etudiants;

}
