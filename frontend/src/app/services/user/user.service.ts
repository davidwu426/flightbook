import { Injectable } from '@angular/core';
import { UserRegister } from '../../models/user-register';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreateCustomerRequest } from '../../models/create-customer-request';
import { NotificationService } from '../notification/notification.service';
import { CreateEmployeeRequest } from '../../models/create-employee-request';
import { Router } from '@angular/router';
import { CreateAdminRequest } from '../../models/create-admin-request';
import { Constants } from '../../constants';
import { UserEntity } from '../../models/user-entity';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  constructor(
    private http: HttpClient,
    private notificationService: NotificationService,
    private router: Router
  ) { }

  registerCustomer(createCustomerRequest: CreateCustomerRequest) {
    return this.http.post<any>(Constants.API_CUSTOMERS_URL, createCustomerRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerEmployee(createEmployeeRequest: CreateEmployeeRequest) {
    return this.http.post<any>(Constants.API_EMPLOYEES_URL, createEmployeeRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerManager(createManagerRequest: CreateEmployeeRequest) {
    return this.http.post<any>(Constants.API_MANAGERS_URL, createManagerRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerAdmin(createAdminRequest: CreateAdminRequest) {
    return this.http.post<any>(Constants.API_ADMINS_URL, createAdminRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  getUsers(): Observable<UserEntity[]> {
    return this.http.get<UserEntity[]>(Constants.API_USERS_URL, Constants.HTTP_OPTIONS);
  }
}
