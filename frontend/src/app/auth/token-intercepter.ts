import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class TokenIntercepter implements HttpInterceptor {
  // constructor(private authService: AuthService) { }
  constructor(private injector: Injector) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authService = this.injector.get(AuthService);

    if (authService.isLoggedIn()) {
      req = req.clone({
        setHeaders: {
          Authorization: authService.getCurrentUser().jwt
        }
      });
    }

    return next.handle(req);
  }
}
