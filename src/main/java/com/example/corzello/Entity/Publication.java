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

    private int upvoteCount ; // Attribute to store upvote count
    private int downvoteCount ; // Attribute to store downvote count

    private int netScore;

    private int commentCount;
    
    private String title;
    private String description;
    private String body;

    private String tags;


    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Vote> votes;


    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Commentaire> commentaires;


    @ManyToOne(cascade = CascadeType.ALL)
    private Forum forum;

}

