import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MostFrequentFlightCardComponent } from './most-frequent-flight-card.component';

describe('MostFrequentFlightCardComponent', () => {
  let component: MostFrequentFlightCardComponent;
  let fixture: ComponentFixture<MostFrequentFlightCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MostFrequentFlightCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MostFrequentFlightCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
