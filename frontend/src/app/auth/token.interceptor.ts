import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpResponse, HttpErrorResponse, HttpHandler, HttpEvent } from '@angular/common/http';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import 'rxjs/add/operator/do';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private injector: Injector
  ) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authService = this.injector.get(AuthService);

    if (authService.isLoggedIn()) {
      req = req.clone({
        setHeaders: {
          Authorization: authService.getCurrentUser().jwt
        }
      });
    }

    return next.handle(req).do((event: HttpEvent<any>) => {
      if (event instanceof HttpResponse) {
        console.log('success');
      }
    }, (err: any) => {
      if (err instanceof HttpErrorResponse) {
        switch (err.status) {
          case 401:
            console.log('Unauthorized');
            break;
          case 403:
            console.log('No permissions');
            break;
          case 409:
            console.log('conflict');
            break;
        }
      }
    });
  }
}
