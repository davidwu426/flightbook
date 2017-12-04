import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth/auth.service';
import { Employee } from '../../models/employee';

@Component({
  selector: 'app-profile-information-manager',
  templateUrl: './profile-information-manager.component.html',
  styleUrls: ['./profile-information-manager.component.css'],
})
export class ProfileInformationManagerComponent implements OnInit {
  manager: Employee;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getManager().subscribe(e => this.manager = e);
  }
}
