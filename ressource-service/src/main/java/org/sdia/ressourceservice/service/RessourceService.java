package org.sdia.ressourceservice.service;

import org.sdia.ressourceservice.entities.Ressource;

import java.util.List;

public interface RessourceService {

    Ressource saveRessource(Ressource ressource);

    List<Ressource> allRessource();

    Ressource updateRessource(Long id,Ressource ressource);

    void deleteRessource(Long id);

}
