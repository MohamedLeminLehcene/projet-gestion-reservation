package org.sdia.reservationservice.dto;

import lombok.*;

import java.awt.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PersonneResponseDTO {
    private Long id;
    private String nom;
    private String email;
}
