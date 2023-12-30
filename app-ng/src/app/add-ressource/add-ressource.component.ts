import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {RessourceService} from "../services/ressource.service";

@Component({
  selector: 'app-add-ressource',
  templateUrl: './add-ressource.component.html',
  styleUrl: './add-ressource.component.css'
})
export class AddRessourceComponent implements OnInit{

  constructor(private ressourceService:RessourceService,private router:Router) {
  }

  ngOnInit(): void {
  }



  onAddRessource(addForm: NgForm) {
    this.ressourceService.addRessource(addForm.value).subscribe(value => {
      this.router.navigate(['/ressources']);
    })
  }

  cancelBtn() {
    this.router.navigate(['/ressources']);
  }
}
