package org.sdia.ressourceservice.web;

import lombok.AllArgsConstructor;
import org.sdia.ressourceservice.dto.RessourceRequestDTO;
import org.sdia.ressourceservice.dto.RessourceResponseDTO;
import org.sdia.ressourceservice.mappers.RessourceMapper;
import org.sdia.ressourceservice.service.RessourceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class RessourceRestController {

    private final RessourceService ressourceService;

    private final RessourceMapper ressourceMapper;


    @PostMapping("/ressources/save")
    public RessourceResponseDTO addRessource(@RequestBody RessourceRequestDTO ressourceRequestDTO){
        return ressourceService.addRessource(ressourceRequestDTO);
    }

    @PutMapping("/ressources/update/{id}")
    public RessourceResponseDTO updateRessource(@PathVariable Long id,@RequestBody RessourceRequestDTO ressourceRequestDTO){

        return ressourceService.updateRessource(id,ressourceRequestDTO);
    }

    @DeleteMapping("/ressources/detele/{id}")
    public void deleteRessource(@PathVariable Long id){
        ressourceService.deleteRessourcer(id);
    }

    @GetMapping("/ressources")
    public List<RessourceResponseDTO> ressourcesList(){
        return ressourceService.allRessources();
    }


}
