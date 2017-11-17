import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchCondensedComponent } from './search-condensed.component';

describe('SearchCondensedComponent', () => {
  let component: SearchCondensedComponent;
  let fixture: ComponentFixture<SearchCondensedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchCondensedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchCondensedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
