import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReservationPersonneComponent } from './reservation-personne.component';

describe('ReservationPersonneComponent', () => {
  let component: ReservationPersonneComponent;
  let fixture: ComponentFixture<ReservationPersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ReservationPersonneComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ReservationPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
