import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileInformationManagerComponent } from './profile-information-manager.component';

describe('ProfileInformationManagerComponent', () => {
  let component: ProfileInformationManagerComponent;
  let fixture: ComponentFixture<ProfileInformationManagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfileInformationManagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileInformationManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
