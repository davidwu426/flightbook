import { Router, CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

// Guard to prevent a page from being accessed without loggin in
@Injectable()
export class AuthGuard implements CanActivate {
  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  canActivate() {
    if (this.authService.isLoggedIn()) {
      return true;
    }

    this.router.navigateByUrl('/login');
    return false;
  }
}
