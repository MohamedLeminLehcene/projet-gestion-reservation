package org.sdia.ressourceservice;

import org.sdia.ressourceservice.dao.RessourceRepository;
import org.sdia.ressourceservice.entities.Ressource;
import org.sdia.ressourceservice.enums.RessourceType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RessourceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RessourceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(RessourceRepository ressourceRepository){
		return args -> {

			ressourceRepository.save(Ressource.builder().nom("ressource1").ressourceType(Math.random()>0.5? RessourceType.MATERIEL_INF0:RessourceType.MATERIEL_AUDIO_VUSUEL).build());
			ressourceRepository.save(Ressource.builder().nom("ressource2").ressourceType(Math.random()>0.5? RessourceType.MATERIEL_INF0:RessourceType.MATERIEL_AUDIO_VUSUEL).build());
			ressourceRepository.save(Ressource.builder().nom("ressource3").ressourceType(Math.random()>0.5? RessourceType.MATERIEL_INF0:RessourceType.MATERIEL_AUDIO_VUSUEL).build());

		};
	}

}
