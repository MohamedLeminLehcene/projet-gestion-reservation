import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Personne} from "../Personne";
import {Reservation} from "../Reservation";

@Injectable({
  providedIn: 'root'
})

export class PersonneService {

  private apiPersonneUrl = 'http://localhost:5555/reservation-service/api/personnes';
  private apiReservationUrl = 'http://localhost:5555/reservation-service/api/reservations/personne/';

  constructor(private http:HttpClient) {

  }

  public getPersonnes():Observable<Personne[]>{
    return this.http.get<Personne[]>(`${this.apiPersonneUrl}`);
  }

  public personneById(personneId : number):Observable<Personne>{
    return this.http.get<Personne>(`${this.apiPersonneUrl}/ById/${personneId}`)
  }


  public addPersonne(personne : Personne):Observable<Personne>{
    return this.http.post<Personne>(`${this.apiPersonneUrl}/save`,personne);
  }

  public updatePersonne(personneId : number,personne : Personne):Observable<Personne>{
    return this.http.put<Personne>(`${this.apiPersonneUrl}/update/${personneId}`,personne);
  }

  public  deletePersonne(personneId : number){
     this.http.delete<void>(`${this.apiPersonneUrl}/delete/${personneId}`);
  }

  public getReservationsPersonneById(personneId : number):Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.apiReservationUrl}${personneId}`);
  }




}
