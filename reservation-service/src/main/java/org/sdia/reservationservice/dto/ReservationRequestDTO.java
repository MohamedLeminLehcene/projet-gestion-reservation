package org.sdia.reservationservice.dto;


import lombok.*;
import org.sdia.reservationservice.entities.Personne;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationRequestDTO {
    private String nom;
    private String contexte;
    private String dure;
    private Long ressourceId;
    private Long personneId;
}

