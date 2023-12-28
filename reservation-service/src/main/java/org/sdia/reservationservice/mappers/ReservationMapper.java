package org.sdia.reservationservice.mappers;

import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.entities.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    public ReservationResponseDTO fromReservation(Reservation reservation){
        ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO();
        BeanUtils.copyProperties(reservation,reservationResponseDTO);
        return reservationResponseDTO;
    }
}