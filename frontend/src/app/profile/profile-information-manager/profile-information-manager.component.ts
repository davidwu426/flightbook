import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { EmployeeEntity } from '../../models/employee-entity';

@Component({
  selector: 'app-profile-information-manager',
  templateUrl: './profile-information-manager.component.html',
  styleUrls: ['./profile-information-manager.component.css'],
})
export class ProfileInformationManagerComponent implements OnInit {
  managerEntity: EmployeeEntity;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getManagerEntity().subscribe(e => this.managerEntity = e);
  }
}
