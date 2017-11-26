import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmployeeEntity } from '../../models/employee-entity';

@Component({
  selector: 'app-profile-information-employee',
  templateUrl: './profile-information-employee.component.html',
  styleUrls: ['./profile-information-employee.component.css'],
})
export class ProfileInformationEmployeeComponent implements OnInit {
  employeeEntity: EmployeeEntity;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getEmployeeEntity().subscribe(e => this.employeeEntity = e);
  }
}
