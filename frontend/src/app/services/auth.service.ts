import { Injectable } from '@angular/core';
import { UserLogin } from '../models/user-login';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserCredentials } from '../models/user-credentials';
import 'rxjs/add/operator/map';

const CURRENT_USER = 'currentUser';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AuthService {
  private loginUrl = 'http://localhost:8080/api/login';

  constructor(private http: HttpClient) { }

  getCurrentUser(): UserCredentials {
    return JSON.parse(localStorage.getItem(CURRENT_USER));
  }

  setCurrentUser(user: UserCredentials): void {
    localStorage.setItem(CURRENT_USER, JSON.stringify(user));
  }

  isLoggedIn(): boolean {
    return this.getCurrentUser() != null;
  }

  login(user: UserLogin): Observable<any> {
    return this.http.post(this.loginUrl, user, httpOptions);
  }

  logout() {
    localStorage.removeItem(CURRENT_USER);
  }
}
