import { Component, OnInit } from '@angular/core';
import { UserEntity } from '../../../models/user-entity';
import { UserService } from '../../../services/user/user.service';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css']
})
export class UserCardComponent implements OnInit {
  users: UserEntity[];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(u => this.users = u);
  }
}
