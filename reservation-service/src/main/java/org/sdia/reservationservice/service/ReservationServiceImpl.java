package org.sdia.reservationservice.service;

import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationRequestDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.mappers.ReservationMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    private final PersonneRepository personneRepository;

    @Override
    public ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO) {

        Reservation reservation = Reservation.builder()
                .nom(reservationRequestDTO.getNom())
                .contexte(reservationRequestDTO.getContexte())
                .date(new Date())
                .dure(reservationRequestDTO.getDure())
                .ressourceId(reservationRequestDTO.getRessourceId())
                .personne(personneRepository.findById(reservationRequestDTO.getPerssoneId()).get())
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
}
