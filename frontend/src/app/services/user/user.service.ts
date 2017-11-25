import { Injectable } from '@angular/core';
import { UserRegister } from '../../models/user-register';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreateCustomerRequest } from '../../models/create-customer-request';
import { NotificationService } from '../notification/notification.service';
import { CreateEmployeeRequest } from '../../models/create-employee-request';
import { Router } from '@angular/router';
import { CreateAdminRequest } from '../../models/create-admin-request';
import { Constants } from '../../constants';

@Injectable()
export class UserService {
  createCustomerUrl = Constants.API_URL + '/customers';
  createEmployeeUrl = Constants.API_URL + '/employees';
  createManagerUrl = Constants.API_URL + '/managers';
  createAdminUrl = Constants.API_URL + '/admins';

  constructor(
    private http: HttpClient,
    private notificationService: NotificationService,
    private router: Router
  ) { }

  registerCustomer(createCustomerRequest: CreateCustomerRequest) {
    return this.http.post<any>(this.createCustomerUrl, createCustomerRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerEmployee(createEmployeeRequest: CreateEmployeeRequest) {
    return this.http.post<any>(this.createEmployeeUrl, createEmployeeRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerManager(createManagerRequest: CreateEmployeeRequest) {
    return this.http.post<any>(this.createManagerUrl, createManagerRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerAdmin(createAdminRequest: CreateAdminRequest) {
    return this.http.post<any>(this.createAdminUrl, createAdminRequest, Constants.HTTP_OPTIONS)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }
}
