import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { UserCredentials } from '../models/user-credentials';
import { Constants } from '../constants';
import { HttpClient } from '@angular/common/http';
import { Role } from '../models/role';
import { Person } from '../models/person';
import { Customer } from '../models/customer';
import { Employee } from '../models/employee';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: UserCredentials;

  role: string;

  person: Person;
  customer: Customer;
  employee: Employee;
  manager: Employee;

  roleConst = Role;

  constructor(
    private authService: AuthService,
    private http: HttpClient
  ) { }

  ngOnInit() {
    this.user = this.authService.getCurrentUser();
    this.authService.getPerson().subscribe(p => this.person = p);
    this.authService.getRole().subscribe(r => this.role = r);
  }
}
