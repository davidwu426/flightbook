import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileInformationCustomerComponent } from './profile-information-customer.component';

describe('ProfileInformationCustomerComponent', () => {
  let component: ProfileInformationCustomerComponent;
  let fixture: ComponentFixture<ProfileInformationCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileInformationCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileInformationCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
