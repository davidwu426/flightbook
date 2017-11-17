import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoundtripSearchComponent } from './roundtrip-search.component';

describe('RoundtripSearchComponent', () => {
  let component: RoundtripSearchComponent;
  let fixture: ComponentFixture<RoundtripSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoundtripSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoundtripSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
