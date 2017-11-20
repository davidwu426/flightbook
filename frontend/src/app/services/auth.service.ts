import { Injectable } from '@angular/core';
import { UserLogin } from '../models/user-login';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const CURRENT_USER = 'currentUser';

@Injectable()
export class AuthService {
  private loginUrl = 'http://localhost:8080/api/login';

  constructor(private http: HttpClient) { }

  getCurrentUser(): UserLogin {
    return JSON.parse(localStorage.getItem(CURRENT_USER));
  }

  setCurrentUser(user: UserLogin): void {
    localStorage.setItem(CURRENT_USER, JSON.stringify(user));
  }

  isLoggedIn(): boolean {
    return this.getCurrentUser() != null;
  }

  login(user: UserLogin): Observable<any> {
    const headers = {
      headers: new HttpHeaders({
        'Authorization': 'Basic ' + btoa(user.username + ':' + user.password),
        'X-Requested-With': 'XMLHttpRequest'
    })};

    this.setCurrentUser(user);
    return this.http.post(this.loginUrl, user, headers);
  }

  logout() {
    localStorage.removeItem(CURRENT_USER);
  }
}
