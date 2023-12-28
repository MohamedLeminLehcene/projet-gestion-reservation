package org.sdia.reservationservice.service;

import org.sdia.reservationservice.dto.RessourceResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "ressource-service")
public interface RessourceRestClientController {

    @GetMapping( "/api/ressources?projection=fullRessource")
    public List<RessourceResponseDTO> ressourcesList();


    @GetMapping("/api/ressources/{id}?projection=fullRessource")
    public RessourceResponseDTO ressourcesById(@PathVariable Long id);

   /*
    @GetMapping("/ressources")
    public List<RessourceResponseDTO> ressourcesList();
    */

}
