import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightsByAirportCardComponent } from './flights-by-airport-card.component';

describe('FlightsByAirportCardComponent', () => {
  let component: FlightsByAirportCardComponent;
  let fixture: ComponentFixture<FlightsByAirportCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightsByAirportCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightsByAirportCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
