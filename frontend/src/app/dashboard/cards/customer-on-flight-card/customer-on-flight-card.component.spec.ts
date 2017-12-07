import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerOnFlightCardComponent } from './customer-on-flight-card.component';

describe('CustomerOnFlightCardComponent', () => {
  let component: CustomerOnFlightCardComponent;
  let fixture: ComponentFixture<CustomerOnFlightCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerOnFlightCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerOnFlightCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
