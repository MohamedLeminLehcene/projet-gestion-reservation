package org.sdia.reservationservice.service;


import org.sdia.reservationservice.dto.PersonneRequestDTO;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.entities.Reservation;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonneService {

    public PersonneResponseDTO addPersonne(PersonneRequestDTO personneRequestDTO);

    public PersonneResponseDTO updatePersonne(Long id,PersonneRequestDTO personneRequestDTO);

    public List<PersonneResponseDTO> allPeronnes();


    public void deletePersonne(Long id);

    public PersonneResponseDTO personneById(Long id);



}
