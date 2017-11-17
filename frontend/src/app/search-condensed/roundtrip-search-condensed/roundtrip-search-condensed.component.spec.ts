import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoundtripSearchCondensedComponent } from './roundtrip-search-condensed.component';

describe('RoundtripSearchCondensedComponent', () => {
  let component: RoundtripSearchCondensedComponent;
  let fixture: ComponentFixture<RoundtripSearchCondensedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoundtripSearchCondensedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoundtripSearchCondensedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
