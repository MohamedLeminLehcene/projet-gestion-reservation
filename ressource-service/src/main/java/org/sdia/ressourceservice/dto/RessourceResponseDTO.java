package org.sdia.ressourceservice.dto;

import lombok.*;
import org.sdia.ressourceservice.enums.RessourceType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RessourceResponseDTO {
    private Long id;
    private String nom;
    private RessourceType ressourceType;
}
