import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {Router} from "@angular/router";
import {Personne} from "../Personne";
import {RessourceService} from "../services/ressource.service";
import {Ressource} from "../Ressource";

@Component({
  selector: 'app-ressources',
  templateUrl: './ressources.component.html',
  styleUrl: './ressources.component.css'
})
export class RessourcesComponent implements OnInit{

  public ressources : any;

  constructor(private ressourceService:RessourceService,private router:Router) {
  }

  ngOnInit() {
    this.getRessources();
  }

  public getRessources():void{
    this.ressourceService.getRessources().subscribe((response:Ressource[])=>{
          this.ressources=response;
        },

    )
  }


  addRessource() {
    this.router.navigateByUrl("/addRessource");
  }

  updateRessource(r: any) {
    this.router.navigateByUrl("/updateRessource/"+r.id);

  }

  deleteRessource(r: any) {
    this.router.navigateByUrl("/deleteRessource/"+r.id);

  }

/*
  reservationPersonneById(p: any) {

    this.router.navigateByUrl("/reservationPersonne/"+p.id);

  }
 */
}
