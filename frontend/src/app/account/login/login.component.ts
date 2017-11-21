import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserLogin } from '../../models/user-login';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';
import { UserCredentials } from '../../models/user-credentials';

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
      .subscribe(res => {
        const jwt = res.jwt;
        const creds = new UserCredentials(this.user.username, jwt);

        this.authService.setCurrentUser(creds);
        this.invalidCredentials = false;
        this.router.navigateByUrl('/');
      }, error => {
        console.log(error);
        this.invalidCredentials = true;
      });
  }
}
