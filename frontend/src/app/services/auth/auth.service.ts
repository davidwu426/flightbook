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
  private loginUrl = Constants.API_URL + '/login';

  private userIdUrl = Constants.API_URL + '/users/id';
  private userUsernameUrl = Constants.API_URL + '/users/username';

  private personUsernameUrl = Constants.API_URL + '/people/username';
  private customerUsernameUrl = Constants.API_URL + '/customers/username';
  private employeeUsernameUrl = Constants.API_URL + '/employees/username';
  private managerUsernameUrl = Constants.API_URL + '/managers/username';

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
    const getRoleUrl = this.userUsernameUrl + `/${this.getCurrentUser().username}/role`;

    return this.http.get<string>(getRoleUrl, Constants.HTTP_OPTIONS_TEXT);
  }

  getPersonEntity(): Observable<PersonEntity> {
    const getPersonUrl = this.personUsernameUrl + `/${this.getCurrentUser().username}`;

    return this.http.get<PersonEntity>(getPersonUrl, Constants.HTTP_OPTIONS);
  }

  getCustomerEntity(): Observable<CustomerEntity> {
    const getCustomerUrl = this.customerUsernameUrl + `/${this.getCurrentUser().username}`;

    return this.http.get<CustomerEntity>(getCustomerUrl, Constants.HTTP_OPTIONS);
  }

  getEmployeeEntity(): Observable<EmployeeEntity> {
    const getEmployeeUrl = this.employeeUsernameUrl + `/${this.getCurrentUser().username}`;

    return this.http.get<EmployeeEntity>(getEmployeeUrl, Constants.HTTP_OPTIONS);
  }

  getManagerEntity(): Observable<EmployeeEntity> {
    const getManagerUrl = this.managerUsernameUrl + `/${this.getCurrentUser().username}`;

    return this.http.get<EmployeeEntity>(getManagerUrl, Constants.HTTP_OPTIONS);
  }

  login(user: UserLogin): Observable<any> {
    return this.http.post(this.loginUrl, user, Constants.HTTP_OPTIONS);
  }

  logout() {
    localStorage.removeItem(Constants.CURRENT_USER_KEY);
  }
}
