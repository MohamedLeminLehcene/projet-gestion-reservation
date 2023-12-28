package org.sdia.reservationservice.mappers;

import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PersonneMapper {

    public PersonneResponseDTO fromPersonne(Personne personne){
        PersonneResponseDTO personneResponseDTO = new PersonneResponseDTO();
        BeanUtils.copyProperties(personne,personneResponseDTO);
        return personneResponseDTO;
    }
}