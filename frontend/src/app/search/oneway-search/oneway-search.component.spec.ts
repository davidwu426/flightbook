import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnewaySearchComponent } from './oneway-search.component';

describe('OnewaySearchComponent', () => {
  let component: OnewaySearchComponent;
  let fixture: ComponentFixture<OnewaySearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnewaySearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnewaySearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
