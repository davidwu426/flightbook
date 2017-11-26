import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileInformationEmployeeComponent } from './profile-information-employee.component';

describe('ProfileInformationEmployeeComponent', () => {
  let component: ProfileInformationEmployeeComponent;
  let fixture: ComponentFixture<ProfileInformationEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileInformationEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileInformationEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
