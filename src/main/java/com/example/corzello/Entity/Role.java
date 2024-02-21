package com.example.corzello.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="roles")
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String name;
}