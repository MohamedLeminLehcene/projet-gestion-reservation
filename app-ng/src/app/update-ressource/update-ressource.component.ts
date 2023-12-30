import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {RessourceService} from "../services/ressource.service";

@Component({
  selector: 'app-update-ressource',
  templateUrl: './update-ressource.component.html',
  styleUrl: './update-ressource.component.css'
})
export class UpdateRessourceComponent implements OnInit{


  ressourceUpdate : any;
  ressourceId! : number;

  constructor(private ressourceService:RessourceService,private router:Router, private route:ActivatedRoute) {

    this.ressourceId=route.snapshot.params["ressourceId"];

  }

  ngOnInit() {
    this.ressourceService.ressourceById(this.ressourceId).subscribe(value => {
      this.ressourceUpdate=value;
    })
  }


  onUpdateRessource(updateForm: NgForm){

    this.ressourceService.updateRessource(this.ressourceId,updateForm.value).subscribe(value => {
      this.router.navigate(['/ressources']);
    })


  }

  cancelBtn() {
    this.router.navigate(['/ressources']);
  }
}
