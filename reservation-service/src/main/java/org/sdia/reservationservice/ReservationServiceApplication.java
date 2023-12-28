package org.sdia.reservationservice;

import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.RessourceResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.service.RessourceRestClientController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner start(ReservationRepository reservationRepository, PersonneRepository personneRepository, RessourceRestClientController ressourceRestClientController){
		return args -> {

			List<RessourceResponseDTO> ressourceResponseDTOList = ressourceRestClientController.ressourcesList();


			Personne personne = Personne
					.builder()
					.nom("Ahmed")
					.email("ahmed@gmail.com")
					.build();

			personneRepository.save(personne);

			Random random= new Random();


			for (int i=0;i <3; i++){

				Reservation reservation = Reservation.builder()
						.nom("Reservation" + i)
						.contexte("contexte "+i)
						.date(new Date())
						.dure("12-01-2023")
						.ressourceId(ressourceResponseDTOList.get(random.nextInt(ressourceResponseDTOList.size())).getId())
						.personne(personne)
						.build();

				reservationRepository.save(reservation);
			}

		};
	}

}
