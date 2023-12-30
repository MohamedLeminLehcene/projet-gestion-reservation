import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {Router} from "@angular/router";
import {Personne} from "../Personne";
import {ReservationService} from "../services/reservation.service";
import {Reservation} from "../Reservation";

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrl: './reservations.component.css'
})
export class ReservationsComponent implements OnInit{

  public reservations : any;

  constructor(private reservationService:ReservationService,private router:Router) {
  }

  ngOnInit() {
    this.getReservations();
  }


  public getReservations():void{
    this.reservationService.getReservations().subscribe((response:Reservation[])=>{
          this.reservations=response;
        },

    )
  }




  updateReservation(p: any) {
    this.router.navigateByUrl("/updateReservation/"+p.id);

  }

  deleteReservation(r: any) {
    this.router.navigateByUrl("/deleteReservation/"+r.id);

  }

  /*
  reservationPersonneById(p: any) {

    this.router.navigateByUrl("/reservationPersonne/"+p.id);

  }
   */
  detailReservation(r: any) {

  }
}
