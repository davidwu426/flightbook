import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MulticitySearchEntryComponent } from './multicity-search-entry.component';

describe('MulticitySearchEntryComponent', () => {
  let component: MulticitySearchEntryComponent;
  let fixture: ComponentFixture<MulticitySearchEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MulticitySearchEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MulticitySearchEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
