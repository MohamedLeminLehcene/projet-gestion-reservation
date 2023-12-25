package org.sdia.ressourceservice.controllers;

import lombok.AllArgsConstructor;
import org.sdia.ressourceservice.dto.RessourceRequestDTO;
import org.sdia.ressourceservice.dto.RessourceResponseDTO;
import org.sdia.ressourceservice.entities.Ressource;
import org.sdia.ressourceservice.service.RessourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RessourceRestController {

    private final RessourceService ressourceService;

    @GetMapping("/ressources")
    public List<Ressource> ressourceList(){
        return ressourceService.allRessource();
    }

    @PostMapping("/ressources/saveRessource")
    public RessourceResponseDTO addRessource(@RequestBody RessourceRequestDTO ressourceRequestDTO){
                return ressourceService.saveRessource(ressourceRequestDTO);
    }
}
