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
public class Recruitement_çprocess_details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRecrutement_PDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    private proposed_job_offer proposedJobOffer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Etudiant etudiant;
    @ManyToOne(cascade = CascadeType.ALL)
    private Recruteur recruteur;


}
