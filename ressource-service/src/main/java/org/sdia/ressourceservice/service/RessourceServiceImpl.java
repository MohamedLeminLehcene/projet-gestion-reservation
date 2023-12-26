package org.sdia.ressourceservice.service;

import lombok.AllArgsConstructor;
import org.sdia.ressourceservice.dao.RessourceRepository;
import org.sdia.ressourceservice.dto.RessourceRequestDTO;
import org.sdia.ressourceservice.dto.RessourceResponseDTO;
import org.sdia.ressourceservice.entities.Ressource;
import org.sdia.ressourceservice.mappers.RessourceMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RessourceServiceImpl implements RessourceService {

    private final RessourceRepository ressourceRepository;

    private final RessourceMapper ressourceMapper;
    @Override
    public RessourceResponseDTO addRessource(RessourceRequestDTO ressourceRequestDTO) {

        Ressource ressource = Ressource.builder()
                .nom(ressourceRequestDTO.getNom())
                .ressourceType(ressourceRequestDTO.getRessourceType())
                .build();

      Ressource savedRessource = ressourceRepository.save(ressource);

     RessourceResponseDTO ressourceResponseDTO = ressourceMapper.fromRessource(savedRessource);


        return ressourceResponseDTO;
    }

    @Override
    public RessourceResponseDTO updateRessource(Long id,RessourceRequestDTO ressourceRequestDTO) {

        Ressource ressource = Ressource.builder()
                .id(id)
                .nom(ressourceRequestDTO.getNom())
                .ressourceType(ressourceRequestDTO.getRessourceType())
                .build();

        Ressource updatedRessource = ressourceRepository.save(ressource);

        RessourceResponseDTO ressourceResponseDTO = ressourceMapper.fromRessource(updatedRessource);

        return ressourceResponseDTO;
    }

    @Override
    public List<RessourceResponseDTO> allRessources() {

        List<Ressource> ressourceList = ressourceRepository.findAll();
        List<RessourceResponseDTO> ressourceResponseDTOList = ressourceList.stream()
                .map(ressourceMapper::fromRessource)
                .collect(Collectors.toList());

        return ressourceResponseDTOList;
    }



    @Override
    public void deleteRessourcer(Long id) {
                ressourceRepository.deleteById(id);
    }
}
