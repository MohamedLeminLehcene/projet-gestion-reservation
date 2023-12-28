package org.sdia.reservationservice.service;


import org.sdia.reservationservice.dto.PersonneRequestDTO;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;

import java.util.List;

public interface PersonneService {

    public PersonneResponseDTO addPersonne(PersonneRequestDTO personneRequestDTO);

    public PersonneResponseDTO updatePersonne(Long id,PersonneRequestDTO personneRequestDTO);

    public List<PersonneResponseDTO> allPeronnes();

    public void deletePersonne(Long id);

}
