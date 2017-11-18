import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserLogin } from '../../models/user-login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  @Input()
  user: UserLogin;

  constructor() { }

  ngOnInit() {
    this.user = new UserLogin();
  }

  login() {
    console.log('log in');
  }
}
