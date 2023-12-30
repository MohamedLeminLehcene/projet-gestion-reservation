import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {ReservationService} from "../services/reservation.service";

@Component({
  selector: 'app-update-reservation',
  templateUrl: './update-reservation.component.html',
  styleUrl: './update-reservation.component.css'
})
export class UpdateReservationComponent implements OnInit{


  reservationUpdate : any;
  reservationId! : number;

  constructor(private reservationService:ReservationService,private router:Router, private route:ActivatedRoute) {

    this.reservationId=route.snapshot.params["reservationId"];

  }

  ngOnInit() {
    this.reservationService.reservationById(this.reservationId).subscribe(value => {
      this.reservationUpdate=value;
    })
  }


  onUpdateReservation(updateForm: NgForm){

    this.reservationService.updateReservation(this.reservationId,updateForm.value).subscribe(value => {
      this.router.navigate(['/reservations']);
    })


  }

  cancelBtn() {
    this.router.navigate(['/reservations']);
  }
}
