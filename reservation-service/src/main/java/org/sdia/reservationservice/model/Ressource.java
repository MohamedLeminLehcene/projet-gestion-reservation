package org.sdia.reservationservice.model;

import lombok.*;
import org.sdia.reservationservice.enums.RessourceType;

@Getter @Setter
public class Ressource {
    private Long id;
    private String nom;
    private String ressourceType;
}
