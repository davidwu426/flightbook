import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserLogin } from '../../models/user-login';
import { UserCredentials } from '../../models/user-credentials';
import { Constants } from '../../constants';

@Injectable()
export class AuthService {
  private loginUrl = Constants.API_URL + '/login';

  constructor(private http: HttpClient) { }

  getCurrentUser(): UserCredentials {
    return JSON.parse(localStorage.getItem(Constants.CURRENT_USER_KEY));
  }

  setCurrentUser(user: UserCredentials): void {
    localStorage.setItem(Constants.CURRENT_USER_KEY, JSON.stringify(user));
  }

  isLoggedIn(): boolean {
    return this.getCurrentUser() != null;
  }

  login(user: UserLogin): Observable<any> {
    return this.http.post(this.loginUrl, user, Constants.HTTP_OPTIONS);
  }

  logout() {
    localStorage.removeItem(Constants.CURRENT_USER_KEY);
  }
}
