import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {Personne} from "../Personne";
import {Router} from "@angular/router";

@Component({
  selector: 'app-personnes',
  templateUrl: './personnes.component.html',
  styleUrl: './personnes.component.css'
})
export class PersonnesComponent implements OnInit{

  public personnes : any;

  constructor(private personneService:PersonneService,private router:Router) {
  }

  ngOnInit() {
    this.getPersonnes();
  }


  public getPersonnes():void{
    this.personneService.getPersonnes().subscribe((response:Personne[])=>{
        this.personnes=response;
      },

    )
  }


  addPersonne() {
    this.router.navigateByUrl("/addPersonne");
  }

  updatePersonne(p: any) {
    this.router.navigateByUrl("/updatePersonne/"+p.id);

  }

  deletePersonne(p: any) {
    this.router.navigateByUrl("/deletePersonne/"+p.id);

  }

  reservationPersonneById(p: any) {

    this.router.navigateByUrl("/reservationPersonne/"+p.id);

  }
}


