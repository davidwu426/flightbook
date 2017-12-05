import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestionsCardComponent } from './suggestions-card.component';

describe('SuggestionsCardComponent', () => {
  let component: SuggestionsCardComponent;
  let fixture: ComponentFixture<SuggestionsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuggestionsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuggestionsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
