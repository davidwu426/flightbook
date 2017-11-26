import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { UserCredentials } from '../models/user-credentials';
import { Constants } from '../constants';
import { HttpClient } from '@angular/common/http';
import { Role } from '../models/role';
import { PersonEntity } from '../models/person-entity';
import { CustomerEntity } from '../models/customer-entity';
import { EmployeeEntity } from '../models/employee-entity';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: UserCredentials;

  role: string;

  personEntity: PersonEntity;
  customerEntity: CustomerEntity;
  employeeEntity: EmployeeEntity;
  managerEntity: EmployeeEntity;

  roleConst = Role;

  constructor(
    private authService: AuthService,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.user = this.authService.getCurrentUser();
    this.authService.getPersonEntity().subscribe(p => this.personEntity = p);
    this.authService.getRole().subscribe(r => this.role = r);
  }
}
