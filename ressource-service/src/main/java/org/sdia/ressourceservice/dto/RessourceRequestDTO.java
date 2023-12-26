package org.sdia.ressourceservice.dto;

import lombok.*;
import org.sdia.ressourceservice.enums.RessourceType;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class RessourceRequestDTO {
    private String nom;
    private RessourceType ressourceType;
}
