package org.sdia.ressourceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sdia.ressourceservice.enums.RessourceType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RessourceRequestDTO {
    private String nom;
    private RessourceType ressourceType;

}
