import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeletePersonneComponent } from './delete-personne.component';

describe('DeletePersonneComponent', () => {
  let component: DeletePersonneComponent;
  let fixture: ComponentFixture<DeletePersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeletePersonneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DeletePersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
