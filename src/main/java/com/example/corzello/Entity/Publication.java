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
@EqualsAndHashCode

public class Publication {
    @EqualsAndHashCode.Exclude
    @ToString.Exclude

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id_publication")
    private Long idPublication;

    private String title;
    private String description;
    private String body;

    private String tags;



    @ManyToOne(cascade = CascadeType.ALL)
    private Vote vote;
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Commentaire>commentaires;

    @ManyToOne(cascade = CascadeType.ALL)
    private Forum forum;

}

