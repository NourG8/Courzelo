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
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCommentaire;

    @OneToMany(mappedBy = "commentaire",cascade = CascadeType.ALL)
    private Set<Publication> publications;

}
