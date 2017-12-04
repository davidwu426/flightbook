import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-profile-information-employee',
  templateUrl: './profile-information-employee.component.html',
  styleUrls: ['./profile-information-employee.component.css'],
})
export class ProfileInformationEmployeeComponent implements OnInit {
  employee: Employee;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getEmployee().subscribe(e => this.employee = e);
  }
}
