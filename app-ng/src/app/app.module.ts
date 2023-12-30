import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReservationsComponent } from './reservations/reservations.component';
import { PersonnesComponent } from './personnes/personnes.component';
import {HttpClientModule} from "@angular/common/http";
import { AddPersonneComponent } from './add-personne/add-personne.component';
import {FormsModule} from "@angular/forms";
import { UpdatePersonneComponent } from './update-personne/update-personne.component';
import { DeletePersonneComponent } from './delete-personne/delete-personne.component';
import { ReservationPersonneComponent } from './reservation-personne/reservation-personne.component';
import { RessourcesComponent } from './ressources/ressources.component';
import { UpdateRessourceComponent } from './update-ressource/update-ressource.component';
import { AddRessourceComponent } from './add-ressource/add-ressource.component';
import { DeleteRessourceComponent } from './delete-ressource/delete-ressource.component';
import { DeleteReservationComponent } from './delete-reservation/delete-reservation.component';
import { AddReservationComponent } from './add-reservation/add-reservation.component';
import { UpdateReservationComponent } from './update-reservation/update-reservation.component';

@NgModule({
  declarations: [
    AppComponent,
    ReservationsComponent,
    PersonnesComponent,
    AddPersonneComponent,
    UpdatePersonneComponent,
    DeletePersonneComponent,
    ReservationPersonneComponent,
    RessourcesComponent,
    UpdateRessourceComponent,
    AddRessourceComponent,
    DeleteRessourceComponent,
    DeleteReservationComponent,
    AddReservationComponent,
    UpdateReservationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
