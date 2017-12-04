import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncludesTableComponent } from './includes-table.component';

describe('IncludesTableComponent', () => {
  let component: IncludesTableComponent;
  let fixture: ComponentFixture<IncludesTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncludesTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncludesTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
