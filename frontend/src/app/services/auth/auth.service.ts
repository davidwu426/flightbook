import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserLogin } from '../../models/user-login';
import { UserCredentials } from '../../models/user-credentials';
import { Constants } from '../../constants';
import { Person } from '../../models/person';
import { Customer } from '../../models/customer';
import { Employee } from '../../models/employee';

@Injectable()
export class AuthService {
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

  getRole(): Observable<string> {
    const getRoleUrl = Constants.API_USER_USERNAME_URL + `/${this.getCurrentUser().username}/role`;

    return this.http.get<string>(getRoleUrl, Constants.HTTP_OPTIONS_TEXT);
  }

  getPerson(): Observable<Person> {
    const getPersonUrl = Constants.API_PERSON_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<Person>(getPersonUrl, Constants.HTTP_OPTIONS);
  }

  getCustomer(): Observable<Customer> {
    const getCustomerUrl = Constants.API_CUSTOMER_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<Customer>(getCustomerUrl, Constants.HTTP_OPTIONS);
  }

  getEmployee(): Observable<Employee> {
    const getEmployeeUrl = Constants.API_EMPLOYEE_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<Employee>(getEmployeeUrl, Constants.HTTP_OPTIONS);
  }

  getManager(): Observable<Employee> {
    const getManagerUrl = Constants.API_MANAGER_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<Employee>(getManagerUrl, Constants.HTTP_OPTIONS);
  }

  login(user: UserLogin): Observable<any> {
    return this.http.post(Constants.API_LOGIN_URL, user, Constants.HTTP_OPTIONS);
  }

  logout() {
    localStorage.removeItem(Constants.CURRENT_USER_KEY);
  }
}
