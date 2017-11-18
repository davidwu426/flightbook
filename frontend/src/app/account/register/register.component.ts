import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserRegister } from '../../models/user-register';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {
  @Input()
  user: UserRegister;

  constructor() { }

  ngOnInit() {
    this.user = new UserRegister();
  }

  register() {
    console.log('register');
  }
}
