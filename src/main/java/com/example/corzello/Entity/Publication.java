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
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPublication;

    @ManyToOne(cascade = CascadeType.ALL)
    private Vote vote;
    @ManyToOne(cascade = CascadeType.ALL)
    private Commentaire commentaire;
    @ManyToOne(cascade = CascadeType.ALL)
    private Forum forum;

}
