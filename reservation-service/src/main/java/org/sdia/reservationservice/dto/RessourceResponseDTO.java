package org.sdia.reservationservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RessourceResponseDTO {
    private Long id;
    private String nom;
    private String ressourceType;
}
