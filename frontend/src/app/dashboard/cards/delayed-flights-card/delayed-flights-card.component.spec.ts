import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DelayedFlightsCardComponent } from './delayed-flights-card.component';

describe('DelayedFlightsCardComponent', () => {
  let component: DelayedFlightsCardComponent;
  let fixture: ComponentFixture<DelayedFlightsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DelayedFlightsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DelayedFlightsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
