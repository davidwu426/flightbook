import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MulticitySearchCondensedComponent } from './multicity-search-condensed.component';

describe('MulticitySearchCondensedComponent', () => {
  let component: MulticitySearchCondensedComponent;
  let fixture: ComponentFixture<MulticitySearchCondensedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MulticitySearchCondensedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MulticitySearchCondensedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
