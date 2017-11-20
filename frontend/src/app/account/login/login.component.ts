import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserLogin } from '../../models/user-login';
import { AuthService } from '../../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  @Input()
  user: UserLogin;

  invalidCredentials = false;

  constructor(
    private authService: AuthService,
    private router: Router) { }

  ngOnInit() {
    this.user = new UserLogin();
    this.invalidCredentials = false;
  }

  login() {
    return this.authService.login(this.user)
      .subscribe(next => {
        this.invalidCredentials = false;
        this.router.navigateByUrl('/');
      }, error => {
        this.invalidCredentials = true;
      });
  }
}
