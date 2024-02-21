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
public class Prog_educatif {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProgEducatif;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Module> Modules;
    @ManyToOne(cascade = CascadeType.ALL)
    private Universite universite;
    @OneToMany(mappedBy = "progEducatif",cascade = CascadeType.ALL)
    private Set<Module>modules;
    @OneToMany(mappedBy = "progEducatif",cascade = CascadeType.ALL)
    private Set<Cours>cours;

}
