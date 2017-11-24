import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpResponse, HttpErrorResponse, HttpHandler, HttpEvent } from '@angular/common/http';
import { AuthService } from '../services/auth/auth.service';
import { Observable } from 'rxjs/Observable';
import { Router } from '@angular/router';
import { NotificationService } from '../services/notification/notification.service';
import 'rxjs/add/operator/do';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(
    private router: Router,
    private injector: Injector,
    private notificationService: NotificationService
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
      }
    }, (err: any) => {
      if (err instanceof HttpErrorResponse) {
        switch (err.status) {
          case 403:
            this.notificationService.error('Your account does not have the necessary permissions to complete this action.');
            this.router.navigateByUrl('/');
            break;
          case 409:
            this.notificationService.error('An entry already exists in the database.');
            this.router.navigateByUrl('/');
            break;
        }

      }
    });
  }
}
