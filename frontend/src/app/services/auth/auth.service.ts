import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { UserLogin } from '../../models/user-login';
import { UserCredentials } from '../../models/user-credentials';
import { Constants } from '../../constants';
import { PersonEntity } from '../../models/person-entity';
import { CustomerEntity } from '../../models/customer-entity';
import { EmployeeEntity } from '../../models/employee-entity';

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

  getPersonEntity(): Observable<PersonEntity> {
    const getPersonUrl = Constants.API_PERSON_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<PersonEntity>(getPersonUrl, Constants.HTTP_OPTIONS);
  }

  getCustomerEntity(): Observable<CustomerEntity> {
    const getCustomerUrl = Constants.API_CUSTOMER_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<CustomerEntity>(getCustomerUrl, Constants.HTTP_OPTIONS);
  }

  getEmployeeEntity(): Observable<EmployeeEntity> {
    const getEmployeeUrl = Constants.API_EMPLOYEE_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<EmployeeEntity>(getEmployeeUrl, Constants.HTTP_OPTIONS);
  }

  getManagerEntity(): Observable<EmployeeEntity> {
    const getManagerUrl = Constants.API_MANAGER_USERNAME_URL + `/${this.getCurrentUser().username}`;

    return this.http.get<EmployeeEntity>(getManagerUrl, Constants.HTTP_OPTIONS);
  }

  login(user: UserLogin): Observable<any> {
    return this.http.post(Constants.API_LOGIN_URL, user, Constants.HTTP_OPTIONS);
  }

  logout() {
    localStorage.removeItem(Constants.CURRENT_USER_KEY);
  }
}
