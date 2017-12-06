import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnewaySearchResultComponent } from './oneway-search-result.component';

describe('OnewaySearchResultComponent', () => {
  let component: OnewaySearchResultComponent;
  let fixture: ComponentFixture<OnewaySearchResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnewaySearchResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnewaySearchResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
