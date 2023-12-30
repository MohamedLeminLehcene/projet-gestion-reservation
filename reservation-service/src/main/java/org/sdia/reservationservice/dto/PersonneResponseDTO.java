package org.sdia.reservationservice.dto;


import lombok.*;
import org.sdia.reservationservice.entities.Reservation;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneResponseDTO {
    private Long id;
    private String nom;
    private String email;
    private List<Reservation> responseDTOList;
}
