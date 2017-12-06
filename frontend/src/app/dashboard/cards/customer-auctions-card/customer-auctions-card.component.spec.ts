import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerAuctionsCardComponent } from './customer-auctions-card.component';

describe('CustomerAuctionsCardComponent', () => {
  let component: CustomerAuctionsCardComponent;
  let fixture: ComponentFixture<CustomerAuctionsCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerAuctionsCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerAuctionsCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
