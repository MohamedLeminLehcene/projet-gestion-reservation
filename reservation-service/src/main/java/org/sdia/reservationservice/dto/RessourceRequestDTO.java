package org.sdia.reservationservice.dto;


import lombok.*;
import org.sdia.reservationservice.enums.RessourceType;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class RessourceRequestDTO {
    private String nom;
    private RessourceType ressourceType;
}
