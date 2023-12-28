package org.sdia.reservationservice.service;

import org.sdia.reservationservice.dto.ReservationRequestDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;

import java.util.List;

public interface ReservationService {

    public ReservationResponseDTO addReservation(ReservationRequestDTO reservationRequestDTO);

    public ReservationResponseDTO updateReservation(Long id,ReservationRequestDTO reservationRequestDTO);

    public List<ReservationResponseDTO> allReservations();

    public void deleteReservation(Long id);
}
