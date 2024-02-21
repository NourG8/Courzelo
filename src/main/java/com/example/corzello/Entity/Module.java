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
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idModule;

    @ManyToOne(cascade = CascadeType.ALL)
    private Prof prof;
    @ManyToOne(cascade = CascadeType.ALL)
    private Prog_educatif progEducatif;
    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL)
    private Set<Cours> cours;
    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

}
