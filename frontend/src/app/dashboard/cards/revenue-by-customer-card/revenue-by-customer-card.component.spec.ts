import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueByCustomerCardComponent } from './revenue-by-customer-card.component';

describe('RevenueByCustomerCardComponent', () => {
  let component: RevenueByCustomerCardComponent;
  let fixture: ComponentFixture<RevenueByCustomerCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevenueByCustomerCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevenueByCustomerCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
