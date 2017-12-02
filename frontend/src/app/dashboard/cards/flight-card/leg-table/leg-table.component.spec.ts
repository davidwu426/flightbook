import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LegTableComponent } from './leg-table.component';

describe('LegTableComponent', () => {
  let component: LegTableComponent;
  let fixture: ComponentFixture<LegTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LegTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LegTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
