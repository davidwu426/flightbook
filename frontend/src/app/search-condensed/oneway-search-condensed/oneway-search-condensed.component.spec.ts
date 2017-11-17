import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnewaySearchCondensedComponent } from './oneway-search-condensed.component';

describe('OnewaySearchCondensedComponent', () => {
  let component: OnewaySearchCondensedComponent;
  let fixture: ComponentFixture<OnewaySearchCondensedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnewaySearchCondensedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnewaySearchCondensedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
