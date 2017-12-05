import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSuggestionsCardComponent } from './customer-suggestions-card.component';

describe('CustomerSuggestionsCardComponent', () => {
  let component: CustomerSuggestionsCardComponent;
  let fixture: ComponentFixture<CustomerSuggestionsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerSuggestionsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerSuggestionsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
