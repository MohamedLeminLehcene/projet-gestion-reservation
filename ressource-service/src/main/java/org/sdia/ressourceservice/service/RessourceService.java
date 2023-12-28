package org.sdia.ressourceservice.service;

import org.sdia.ressourceservice.dto.RessourceRequestDTO;
import org.sdia.ressourceservice.dto.RessourceResponseDTO;

import java.util.List;

public interface RessourceService {

    public RessourceResponseDTO addRessource(RessourceRequestDTO ressourceRequestDTO);

    public RessourceResponseDTO updateRessource(Long id,RessourceRequestDTO ressourceRequestDTO);

    public List<RessourceResponseDTO> allRessources();

    public void deleteRessourcer(Long id);

    public RessourceResponseDTO ressourcesById(Long id);
}
