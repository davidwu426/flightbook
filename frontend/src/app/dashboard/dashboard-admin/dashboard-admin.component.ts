import { Component, OnInit, Input } from '@angular/core';
import { UserEntity } from '../../models/user-entity';
import { UserService } from '../../services/user/user.service';
import { AirlineService } from '../../services/airline/airline.service';
import { Airline } from '../../models/airline';

@Component({
  selector: 'app-dashboard-admin',
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css']
})
export class DashboardAdminComponent implements OnInit {
  users: UserEntity[];

  constructor(
    private userService: UserService
  ) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(u => this.users = u);
  }
}
