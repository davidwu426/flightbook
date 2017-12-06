import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LegDetailComponent } from './leg-detail.component';

describe('LegDetailComponent', () => {
  let component: LegDetailComponent;
  let fixture: ComponentFixture<LegDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LegDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LegDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
