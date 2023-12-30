package org.sdia.reservationservice.dao;

import org.sdia.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findByPersonneId(Long personneId);
}
