import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ReservationsComponent} from "./reservations/reservations.component";
import {PersonnesComponent} from "./personnes/personnes.component";
import {AddPersonneComponent} from "./add-personne/add-personne.component";
import {UpdatePersonneComponent} from "./update-personne/update-personne.component";
import {DeletePersonneComponent} from "./delete-personne/delete-personne.component";
import {ReservationPersonneComponent} from "./reservation-personne/reservation-personne.component";
import {RessourcesComponent} from "./ressources/ressources.component";
import {AddRessourceComponent} from "./add-ressource/add-ressource.component";
import {UpdateRessourceComponent} from "./update-ressource/update-ressource.component";
import {DeleteRessourceComponent} from "./delete-ressource/delete-ressource.component";
import {AddReservationComponent} from "./add-reservation/add-reservation.component";
import {UpdateReservationComponent} from "./update-reservation/update-reservation.component";
import {DeleteReservationComponent} from "./delete-reservation/delete-reservation.component";

const routes: Routes = [
  {path:"reservations",component:ReservationsComponent},
  {
    path:"personnes",component:PersonnesComponent
  },
  {
    path:"addPersonne",component:AddPersonneComponent
  },
  {
    path:"updatePersonne/:personneId",component:UpdatePersonneComponent
  },
  {
    path:"deletePersonne/:personneId",component:DeletePersonneComponent
  },
  {
    path:"reservationPersonne/:personneId",component:ReservationPersonneComponent
  },

  {
    path:"ressources",component:RessourcesComponent
  },
  {
    path:"addRessource",component:AddRessourceComponent
  },
  {
    path:"updateRessource/:ressourceId",component:UpdateRessourceComponent
  },
  {
    path:"deleteRessource/:ressourceId",component:DeleteRessourceComponent
  },




  {
    path:"reservations",component:ReservationsComponent
  },

  {
    path:"addReservation/:personneId",component:AddReservationComponent
  },
  {
    path:"updateReservation/:reservationId",component:UpdateReservationComponent
  },
  {
    path:"deleteReservation/:reservationId",component:DeleteReservationComponent
  },
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
