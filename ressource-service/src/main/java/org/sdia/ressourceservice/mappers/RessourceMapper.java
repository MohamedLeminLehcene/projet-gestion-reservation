package org.sdia.ressourceservice.mappers;

import org.sdia.ressourceservice.dto.RessourceResponseDTO;
import org.sdia.ressourceservice.entities.Ressource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RessourceMapper {

    public RessourceResponseDTO fromRessource(Ressource ressource){
        RessourceResponseDTO ressourceResponseDTO = new RessourceResponseDTO();
        BeanUtils.copyProperties(ressource,ressourceResponseDTO);
        return ressourceResponseDTO;
    }


}

