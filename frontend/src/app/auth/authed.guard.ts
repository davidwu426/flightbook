import { Router, CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

// Guard to prevent a page from being accessed if user is already logged in
@Injectable()
export class AuthedGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  canActivate() {
    if (!this.authService.isLoggedIn()) {
      return true;
    }

    this.router.navigateByUrl('/');
    return false;
  }
}
