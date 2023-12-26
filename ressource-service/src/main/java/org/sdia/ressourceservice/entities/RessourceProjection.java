package org.sdia.ressourceservice.entities;

import org.sdia.ressourceservice.enums.RessourceType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullRessource",types = Ressource.class)
public interface RessourceProjection {
     public Long getId();
    public String getNom();
    public RessourceType getRessourceType();
}


