import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Personne} from "../Personne";
import {Reservation} from "../Reservation";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private apiReservationUrl = 'http://localhost:5555/reservation-service/api/reservations';
  constructor(private http:HttpClient) {

  }

  public getReservations():Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.apiReservationUrl}`);
  }

  public reservationById(reservationId : number):Observable<Reservation>{
    return this.http.get<Reservation>(`${this.apiReservationUrl}/ById/${reservationId}`)
  }

  public addReservation(reservation : Reservation):Observable<Reservation>{
    return this.http.post<Reservation>(`${this.apiReservationUrl}/save`,reservation);
  }

  public updateReservation(reservationId : number,reservation : Reservation):Observable<Reservation>{
    return this.http.put<Reservation>(`${this.apiReservationUrl}/update/${reservationId}`,reservation);
  }

  public  deleteReservation(reservationId : number){
    this.http.delete<void>(`${this.apiReservationUrl}/delete/${reservationId}`);
  }

  /*
  public getReservationsPersonneById(personneId : number):Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.apiReservationUrl}${personneId}`);
  }
   */




}
