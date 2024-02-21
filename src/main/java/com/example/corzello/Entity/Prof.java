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
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private Set<Calendrier> Calendriers;
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private Set<Module> Modules;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classe> classes;

}
