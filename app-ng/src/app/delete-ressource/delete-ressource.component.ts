import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {RessourceService} from "../services/ressource.service";

@Component({
  selector: 'app-delete-ressource',
  templateUrl: './delete-ressource.component.html',
  styleUrl: './delete-ressource.component.css'
})
export class DeleteRessourceComponent implements OnInit{

  private ressourceId!:number;

  constructor(private ressourceService:RessourceService,private router:Router, private route:ActivatedRoute) {

    this.ressourceId=route.snapshot.params["ressourceId"];

  }
  ngOnInit(): void {

  }

  cancelBtn() {
    this.router.navigate(['/ressources']);
  }

  ngDelete(deleteRessource: NgForm) {
    this.ressourceService.deleteRessource(this.ressourceId);
    this.router.navigate(['/ressources']);
  }
}
