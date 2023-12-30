import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {ReservationService} from "../services/reservation.service";
import {PersonneService} from "../services/personne.service";

@Component({
  selector: 'app-add-reservation',
  templateUrl: './add-reservation.component.html',
  styleUrl: './add-reservation.component.css'
})
export class AddReservationComponent implements OnInit{

  public personneId! : number;

  constructor(private reservationService:ReservationService,private router:Router, private route:ActivatedRoute) {

    this.personneId=route.snapshot.params["personneId"];

  }

  ngOnInit(): void {
  }



  onAddReservation(addForm: NgForm) {
    console.log(addForm.value);
    this.reservationService.addReservation(addForm.value).subscribe(value => {
      this.router.navigate(['/reservations']);
    })
  }

  cancelBtn() {
    this.router.navigate(['/reservations']);
  }
}
