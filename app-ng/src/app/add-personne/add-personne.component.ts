import {Component, OnInit} from '@angular/core';
import {NgForm} from "@angular/forms";
import {PersonneService} from "../services/personne.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-personne',
  templateUrl: './add-personne.component.html',
  styleUrl: './add-personne.component.css'
})
export class AddPersonneComponent implements OnInit{

  constructor(private personneService:PersonneService,private router:Router) {
  }

  ngOnInit(): void {
  }



  onAddPersonne(addForm: NgForm) {
    this.personneService.addPersonne(addForm.value).subscribe(value => {
      this.router.navigate(['/personnes']);
    })
  }

  cancelBtn() {
    this.router.navigate(['/personnes']);
  }
}
