import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {PersonneService} from "../services/personne.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-update-personne',
  templateUrl: './update-personne.component.html',
  styleUrl: './update-personne.component.css'
})
export class UpdatePersonneComponent implements OnInit{


  personneUpdate : any;
  personneId! : number;

  constructor(private personneService:PersonneService,private router:Router, private route:ActivatedRoute) {

    this.personneId=route.snapshot.params["personneId"];

  }

  ngOnInit() {
    this.personneService.personneById(this.personneId).subscribe(value => {
      this.personneUpdate=value;
    })
  }


    onUpdatePersonne(updateForm: NgForm){

    this.personneService.updatePersonne(this.personneId,updateForm.value).subscribe(value => {
        this.router.navigate(['/personnes']);
    })


  }

    cancelBtn() {
        this.router.navigate(['/personnes']);
    }
}
