import {Component, OnInit} from '@angular/core';
import {PersonneService} from "../services/personne.service";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-delete-personne',
  templateUrl: './delete-personne.component.html',
  styleUrl: './delete-personne.component.css'
})
export class DeletePersonneComponent implements OnInit{

  private personneId!:number;

  constructor(private personneService:PersonneService,private router:Router, private route:ActivatedRoute) {

    this.personneId=route.snapshot.params["personneId"];

  }
  ngOnInit(): void {

  }

  cancelBtn() {
    this.router.navigate(['/personnes']);
  }

  ngDelete(deletePersonne: NgForm) {
    this.personneService.deletePersonne(this.personneId);
    this.router.navigate(['/personnes']);
  }
}
