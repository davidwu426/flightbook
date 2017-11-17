import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MulticitySearchComponent } from './multicity-search.component';

describe('MulticitySearchComponent', () => {
  let component: MulticitySearchComponent;
  let fixture: ComponentFixture<MulticitySearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MulticitySearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MulticitySearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
