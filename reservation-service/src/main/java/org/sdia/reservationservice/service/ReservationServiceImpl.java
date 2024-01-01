package org.sdia.reservationservice.service;

import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.ReservationRequestDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.dto.RessourceResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.mappers.ReservationMapper;
import org.sdia.reservationservice.model.Ressource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient;

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

            String jwtTokenValue= getUserInfo();

            RestClient restClient = RestClient.create("http://localhost:8081");

            RessourceResponseDTO ressourceResponseDTO = restClient.get()
                    .uri("/api/ressources/"+reservation.getRessourceId()+"?projection=fullRessource")
                    .headers(httpHeaders -> httpHeaders.set(HttpHeaders.AUTHORIZATION, "Bearer "+jwtTokenValue))
                    .retrieve()
                    .body(new ParameterizedTypeReference<>(){});

            Ressource ressource = new Ressource();
            ressource.setId(ressourceResponseDTO.getId());

            ressource.setNom(ressourceResponseDTO.getNom());

            ressource.setRessourceType(ressourceResponseDTO.getRessourceType());

            reservation.setRessource(ressource);

        });

        return reservationList;

    }

    public String getUserInfo() {
        // Retrieve the authentication object from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        if (authentication.isAuthenticated() && authentication instanceof JwtAuthenticationToken) {
            // Extract JWT from JwtAuthenticationToken
            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
            return jwtAuthenticationToken.getToken().getTokenValue();
        }

        // Return an error message if the user is not authenticated or the token is not a JWT
        return "Error retrieving user information";
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

