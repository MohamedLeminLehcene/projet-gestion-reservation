import {Ressource} from "./Ressource";
import {Personne} from "./Personne";

export interface Reservation{

    id : number;
    nom : string;
    contexte:string;
    dure:string;
    date:Date;
    ressourceId:number;
    ressource:Ressource;
    personne:Personne;
}


