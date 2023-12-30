import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-reservation-personne',
  templateUrl: './reservation-personne.component.html',
  styleUrl: './reservation-personne.component.css'
})

export class ReservationPersonneComponent  implements OnInit{
  public reservations! : any;

  public personne!:any;

  personneId! : number;

  constructor(private personneService:PersonneService,private router:Router, private route:ActivatedRoute) {

    this.personneId=route.snapshot.params["personneId"];

  }
  ngOnInit(): void {
   this.getReservationsPersonneById();
   this.chargerPersonneParId();
  }

  chargerPersonneParId(){
    this.personneService.personneById(this.personneId).subscribe(value => {
      this.personne=value;
    })
  }

  getReservationsPersonneById(){
    this.personneService.getReservationsPersonneById(this.personneId).subscribe(value => {
      this.reservations=value;
    })
  }

  protected readonly NgIf = NgIf;

  addReservation(personneId: number) {
    this.router.navigateByUrl("/addReservation/"+personneId);
  }
}

