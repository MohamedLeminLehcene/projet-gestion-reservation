package org.sdia.reservationservice.web;

import lombok.AllArgsConstructor;
import org.sdia.reservationservice.dao.PersonneRepository;
import org.sdia.reservationservice.dao.ReservationRepository;
import org.sdia.reservationservice.dto.PersonneRequestDTO;
import org.sdia.reservationservice.dto.PersonneResponseDTO;
import org.sdia.reservationservice.dto.ReservationResponseDTO;
import org.sdia.reservationservice.entities.Personne;
import org.sdia.reservationservice.entities.Reservation;
import org.sdia.reservationservice.mappers.PersonneMapper;
import org.sdia.reservationservice.service.PersonneService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class PersonneRestController {

    private final PersonneService personneService;

    private final PersonneRepository personneRepository;

    private final ReservationRepository reservationRepository;

    private final PersonneMapper personneMapper;

    @PostMapping("/personnes/save")
    public PersonneResponseDTO addPersonne(@RequestBody PersonneRequestDTO personneRequestDTO){
        return personneService.addPersonne(personneRequestDTO);

    }

    @PutMapping("/personnes/update/{id}")
    public PersonneResponseDTO updatePersonne(@PathVariable Long id,  @RequestBody PersonneRequestDTO personneRequestDTO){
        return personneService.updatePersonne(id,personneRequestDTO);
    }

    @GetMapping("/personnes")
    public List<PersonneResponseDTO> allPersonnes(){
        return personneService.allPeronnes();
    }


    @DeleteMapping("/peronnes/delete/{id}")
    public void deletePersonne(@PathVariable Long id){
        personneService.deletePersonne(id);
    }

    @GetMapping("/personnes/ById/{id}")
    public PersonneResponseDTO personneById(@PathVariable Long id){
     return  personneService.personneById(id);
    }

}

