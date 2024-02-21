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
public class reponses_etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResponsesEtudiant;

    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;
    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

}
