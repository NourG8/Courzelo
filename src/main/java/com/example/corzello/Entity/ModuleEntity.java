package com.example.corzello.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

public class ModuleEntity implements Serializable {
    @Id
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModule;

    private int nbr_chapitres;

    private String nom_module;

    private String Description;

    private double credit;

    private int duree_module;



    @ManyToOne(cascade = CascadeType.ALL)
    private Prof prof;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProg")
    @JsonIgnore
    private Prog_educatif progEducatif;
    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)

    private Set<Cours> cours;
    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

}
