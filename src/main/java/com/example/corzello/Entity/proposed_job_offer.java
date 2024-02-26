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
public class proposed_job_offer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJobOffer;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Recruteur> recruteurs;
    @OneToMany(mappedBy = "proposedJobOffer",cascade = CascadeType.ALL)
    private Set<Recruitement_process_details> recruitementprocessDetails;

}
