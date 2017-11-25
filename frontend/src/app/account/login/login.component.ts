import { Component, OnInit, ViewEncapsulation, Input } from '@angular/core';
import { UserLogin } from '../../models/user-login';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';
import { UserCredentials } from '../../models/user-credentials';
import { NotificationService } from '../../services/notification/notification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  @Input()
  user: UserLogin;

  private isLoading = false;

  constructor(
    private authService: AuthService,
    private router: Router,
    private notificationService: NotificationService
  ) { }

  ngOnInit() {
    this.user = new UserLogin();
  }

  login() {
    this.isLoading = true;

    return this.authService.login(this.user)
      .subscribe(res => {
        const jwt = res.jwt;
        const creds = new UserCredentials(this.user.username, jwt);

        this.authService.setCurrentUser(creds);
        this.router.navigateByUrl('/');
      }, error => {
        this.notificationService.error('Invalid username or password.');
      });
  }
}
