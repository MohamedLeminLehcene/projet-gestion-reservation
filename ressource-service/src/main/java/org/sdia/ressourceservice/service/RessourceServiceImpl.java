package org.sdia.ressourceservice.service;

import lombok.AllArgsConstructor;
import org.sdia.ressourceservice.dao.RessourceRepository;
import org.sdia.ressourceservice.entities.Ressource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RessourceServiceImpl implements RessourceService{

    private final RessourceRepository ressourceRepository;

    @Override
    public Ressource saveRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public List<Ressource> allRessource() {
        return ressourceRepository.findAll();
    }

    @Override
    public Ressource updateRessource(Long id, Ressource ressource) {

        Ressource r1 = ressourceRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        r1.setNom(ressource.getNom());
        r1.setRessourceType(ressource.getRessourceType());

        return ressourceRepository.save(r1);
    }

    @Override
    public void deleteRessource(Long id) {
        ressourceRepository.deleteById(id);
    }
}
