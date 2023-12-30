import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ressource} from "../Ressource";

@Injectable({
  providedIn: 'root'
})
export class RessourceService {


  private apiRessourceUrl = 'http://localhost:5555/ressource-service/api/ressources';

  constructor(private http:HttpClient) {

  }

  public getRessources():Observable<Ressource[]>{
    return this.http.get<Ressource[]>(`${this.apiRessourceUrl}`);
  }

  public ressourceById(ressourceId : number):Observable<Ressource>{
    return this.http.get<Ressource>(`${this.apiRessourceUrl}/${ressourceId}`)
  }


  public addRessource(ressource : Ressource):Observable<Ressource>{
    return this.http.post<Ressource>(`${this.apiRessourceUrl}/save`,ressource);
  }

  public updateRessource(ressourceId : number,ressource : Ressource):Observable<Ressource>{
    return this.http.put<Ressource>(`${this.apiRessourceUrl}/update/${ressourceId}`,ressource);
  }

  public  deleteRessource(ressourceId : number){
    this.http.delete<void>(`${this.apiRessourceUrl}/delete/${ressourceId}`);
  }

/*
  public getReservationsRessourceById(ressourceId : number):Observable<Reservation[]>{
    return this.http.get<Reservation[]>(`${this.apiReservationUrl}${personneId}`);
  }
 */



}
