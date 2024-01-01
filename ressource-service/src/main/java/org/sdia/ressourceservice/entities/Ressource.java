package org.sdia.ressourceservice.entities;


import jakarta.persistence.*;
import lombok.*;
import org.sdia.ressourceservice.enums.RessourceType;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @Enumerated(EnumType.STRING)
    private RessourceType ressourceType;
}


