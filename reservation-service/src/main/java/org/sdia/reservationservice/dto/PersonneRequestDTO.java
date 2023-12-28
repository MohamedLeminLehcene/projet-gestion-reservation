package org.sdia.reservationservice.dto;


import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PersonneRequestDTO {
    private String nom;
    private String email;
}
