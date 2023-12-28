package org.sdia.reservationservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.PersonneRequestDTO;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.dto.RessourceResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.mappers.PersonneMapper;
import org.sdia.reservationservice.mappers.ReservationMapper;
import org.sdia.reservationservice.model.Ressource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonneServiceImpl implements PersonneService{

    private final PersonneMapper personneMapper;

    private final PersonneRepository personneRepository;

    private final ReservationService reservationService;

    private final ReservationRepository reservationRepository;

    private final RessourceRestClientController ressourceRestClientController;

    private final ReservationMapper reservationMapper;
    @Override
    public PersonneResponseDTO addPersonne(PersonneRequestDTO personneRequestDTO) {

        Personne personne = Personne.builder()
                .nom(personneRequestDTO.getNom())
                .email(personneRequestDTO.getEmail())
                .build();

        Personne savedPersonne = personneRepository.save(personne);

        PersonneResponseDTO personneResponseDTO = personneMapper.fromPersonne(savedPersonne);


        return personneResponseDTO;
    }

    @Override
    public PersonneResponseDTO updatePersonne(Long id,PersonneRequestDTO personneRequestDTO) {

        Personne personne = personneRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        personne.setNom(personneRequestDTO.getNom());
        personne.setEmail(personneRequestDTO.getEmail());

        Personne updatedPersonne = personneRepository.save(personne);

        PersonneResponseDTO personneResponseDTO = personneMapper.fromPersonne(updatedPersonne);

        return personneResponseDTO;
    }

    @Override
    public List<PersonneResponseDTO> allPeronnes() {

        List<Personne> personneList =  personneRepository.findAll();

        List<PersonneResponseDTO> personneResponseDTOList = personneList.stream()
                .map(personneMapper::fromPersonne).collect(Collectors.toList());

        return  personneResponseDTOList;
    }

    /*
    @Override
    public List<ReservationResponseDTO> allPeronnes() {

        Personne personne = personneRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Personne with ID 1 not found"));


        Reservation reservation = reservationRepository.findById(1L).get();

        RessourceResponseDTO ressourceResponseDTO = ressourceRestClientController.ressourcesById(reservation.getRessourceId());

        Ressource res1 = new Ressource();
        res1.setId(ressourceResponseDTO.getId());
        res1.setNom(ressourceResponseDTO.getNom());
        res1.setRessourceType(ressourceResponseDTO.getRessourceType());

        reservation.setRessource(res1);

        reservation.setPersonne(personne);

        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(reservation);


        List<ReservationResponseDTO> reservationList = Collections.singletonList(reservationResponseDTO);

        return reservationList;
    }
     */

    @Override
    public void deletePersonne(Long id) {
            personneRepository.deleteById(id);
    }
}
