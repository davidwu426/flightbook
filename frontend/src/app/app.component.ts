import { Component } from '@angular/core';
import { AuthService } from './services/auth/auth.service';
import { Router } from '@angular/router';
import { UserCredentials } from './models/user-credentials';
import { NotificationService } from './services/notification/notification.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Flightbook';
  currentUser: UserCredentials;
  isLoggedIn: boolean;

  constructor(
    private authService: AuthService,
    private router: Router,
    private notificationsService: NotificationService
  ) { }

  logout() {
    this.authService.logout();
    this.notificationsService.success('You have logged out.');
    this.router.navigateByUrl('/');
  }
}
