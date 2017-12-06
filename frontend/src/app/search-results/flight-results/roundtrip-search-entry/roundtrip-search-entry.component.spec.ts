import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoundtripSearchEntryComponent } from './roundtrip-search-entry.component';

describe('RoundtripSearchEntryComponent', () => {
  let component: RoundtripSearchEntryComponent;
  let fixture: ComponentFixture<RoundtripSearchEntryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoundtripSearchEntryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoundtripSearchEntryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
