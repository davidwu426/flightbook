import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerReservationCardComponent } from './customer-reservation-card.component';

describe('CustomerReservationCardComponent', () => {
  let component: CustomerReservationCardComponent;
  let fixture: ComponentFixture<CustomerReservationCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerReservationCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerReservationCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
