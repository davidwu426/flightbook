import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueByCustomerRepCardComponent } from './revenue-by-customer-rep-card.component';

describe('RevenueByCustomerRepCardComponent', () => {
  let component: RevenueByCustomerRepCardComponent;
  let fixture: ComponentFixture<RevenueByCustomerRepCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RevenueByCustomerRepCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RevenueByCustomerRepCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
