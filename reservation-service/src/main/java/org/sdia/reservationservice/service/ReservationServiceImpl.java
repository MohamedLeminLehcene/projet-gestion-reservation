package org.sdia.reservationservice.service;

import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationRequestDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.dto.RessourceResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.mappers.ReservationMapper;
import org.sdia.reservationservice.model.Ressource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService{


    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    private final PersonneRepository personneRepository;

    private final RessourceRestClientController ressourceRestClientController;


    @Override
    public ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO) {

        Reservation reservation = Reservation.builder()
                .nom(reservationRequestDTO.getNom())
                .contexte(reservationRequestDTO.getContexte())
                .date(new Date())
                .dure(reservationRequestDTO.getDure())
                .ressourceId(reservationRequestDTO.getRessourceId())
                .personne(personneRepository.findById(reservationRequestDTO.getPersonneId()).get())
                .build();

       Reservation savedReservation = reservationRepository.save(reservation);

        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(savedReservation);

        return reservationResponseDTO;
    }

    @Override
    public ReservationResponseDTO updateReservation(Long id, ReservationRequestDTO reservationRequestDTO) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException());

        reservation.setNom(reservationRequestDTO.getNom());
        reservation.setContexte(reservationRequestDTO.getContexte());
        reservation.setDure(reservationRequestDTO.getDure());
        reservation.setRessourceId(reservationRequestDTO.getRessourceId());

        Reservation updatedReservation = reservationRepository.save(reservation);

        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(updatedReservation);

        return reservationResponseDTO;
    }

    @Override
    public List<ReservationResponseDTO> allReservations() {

        List<Reservation> reservationList =  reservationRepository.findAll();

        List<ReservationResponseDTO> reservationResponseDTOList = reservationList.stream()
                .map(reservationMapper::fromReservation).collect(Collectors.toList());

        return reservationResponseDTOList;
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> getReservationsByPersonId(Long personId) {

        List<Reservation> reservationList = reservationRepository.findByPersonneId(personId);

        reservationList.forEach(reservation -> {

            RessourceResponseDTO ressourceResponseDTO = ressourceRestClientController.ressourcesById(reservation.getRessourceId());

            Ressource ressource = new Ressource();
            ressource.setId(ressourceResponseDTO.getId());

            ressource.setNom(ressourceResponseDTO.getNom());

            ressource.setRessourceType(ressourceResponseDTO.getRessourceType());

            reservation.setRessource(ressource);

        });

        return reservationList;

    }




    @Override
    public ReservationResponseDTO reservationByIdDetail(Long id) {

        Reservation reservation = reservationRepository.findById(id).orElseThrow();

        RessourceResponseDTO ressourceResponseDTO = ressourceRestClientController.ressourcesById(reservation.getRessourceId());

        Personne personne = personneRepository.findById(reservation.getPersonne().getId()).get();


        Ressource ressource = new Ressource();

        ressource.setId(ressourceResponseDTO.getId());

        ressource.setNom(ressourceResponseDTO.getNom());

        ressource.setRessourceType(ressourceResponseDTO.getRessourceType());

        reservation.setRessource(ressource);

        reservation.setPersonne(personne);

        ReservationResponseDTO reservationResponseDTO = reservationMapper.fromReservation(reservation);

        return reservationResponseDTO;
    }


}

