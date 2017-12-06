import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnTimeFlightCardComponent } from './on-time-flight-card.component';

describe('OnTimeFlightCardComponent', () => {
  let component: OnTimeFlightCardComponent;
  let fixture: ComponentFixture<OnTimeFlightCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnTimeFlightCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnTimeFlightCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
