import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BestSoldFlightsCardComponent } from './best-sold-flights-card.component';

describe('BestSoldFlightsCardComponent', () => {
  let component: BestSoldFlightsCardComponent;
  let fixture: ComponentFixture<BestSoldFlightsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BestSoldFlightsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BestSoldFlightsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
