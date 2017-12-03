import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonInfoEditComponent } from './person-info-edit.component';

describe('PersonInfoEditComponent', () => {
  let component: PersonInfoEditComponent;
  let fixture: ComponentFixture<PersonInfoEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonInfoEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonInfoEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
