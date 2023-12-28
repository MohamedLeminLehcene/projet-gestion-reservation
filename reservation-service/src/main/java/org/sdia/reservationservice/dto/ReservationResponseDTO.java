package org.sdia.reservationservice.dto;


import lombok.*;
import org.sdia.reservationservice.entities.Personne;

import java.util.Date;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ReservationResponseDTO {
    private Long id;
    private String nom;
    private String contexte;
    private Date date;
    private String dure;
    private Long ressourceId;
    private Personne personne;
}
