import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileInformationAdminComponent } from './profile-information-admin.component';

describe('ProfileInformationAdminComponent', () => {
  let component: ProfileInformationAdminComponent;
  let fixture: ComponentFixture<ProfileInformationAdminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileInformationAdminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileInformationAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
