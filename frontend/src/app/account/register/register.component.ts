import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserRegister } from '../../models/user-register';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {
  @Input()
  user: UserRegister;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.user = new UserRegister();
  }

  register() {
    switch (this.user.type) {
      case 'customer':
        this.userService.registerCustomer(this.user.convertToCreateCustomerRequest());
        break;
      case 'employee':
        this.userService.registerEmployee(this.user);
        break;
      case 'manager':
        this.userService.registerManager(this.user);
        break;
      case 'admin':
        this.userService.registerAdmin(this.user);
        break;
    }
  }
}
