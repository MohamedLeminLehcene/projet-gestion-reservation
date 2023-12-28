package org.sdia.reservationservice.web;

import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dto.*;
import org.sdia.reservationservice.mappers.ReservationMapper;
import org.sdia.reservationservice.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReservationRestController {

    private final ReservationService reservationService;
    private  final ReservationMapper reservationMapper;

    @PostMapping("/reservations/save")
    public ReservationResponseDTO addReservation(@RequestBody ReservationRequestDTO reservationRequestDTO){
        return reservationService.addReservation(reservationRequestDTO);

    }

    @PutMapping("/reservations/update/{id}")
    public ReservationResponseDTO updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDTO reservationRequestDTO){
        return reservationService.updateReservation(id,reservationRequestDTO);
    }

    @GetMapping("/reservations")
    public List<ReservationResponseDTO> allReservations(){
        return reservationService.allReservations();
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
    }

}
