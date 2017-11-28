import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { Role } from '../models/role';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class DashboardComponent implements OnInit {
  role: string;
  roleConst = Role;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.authService.getRole().subscribe(r => this.role = r);
  }
}
