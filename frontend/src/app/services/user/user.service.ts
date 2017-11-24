import { Injectable } from '@angular/core';
import { UserRegister } from '../../models/user-register';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreateCustomerRequest } from '../../models/create-customer-request';
import { NotificationService } from '../notification/notification.service';
import { CreateEmployeeRequest } from '../../models/create-employee-request';
import { Router } from '@angular/router';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {
  createCustomerUrl = 'http://localhost:8080/api/customers';
  createEmployeeUrl = 'http://localhost:8080/api/employees';
  createManagerUrl = 'http://localhost:8080/api/managers';

  constructor(
    private http: HttpClient,
    private notificationService: NotificationService,
    private router: Router
  ) { }

  registerCustomer(createCustomerRequest: CreateCustomerRequest) {
    return this.http.post<any>(this.createCustomerUrl, createCustomerRequest, httpOptions)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerEmployee(createEmployeeRequest: CreateEmployeeRequest) {
    return this.http.post<any>(this.createEmployeeUrl, createEmployeeRequest, httpOptions)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerManager(createManagerRequest: CreateEmployeeRequest) {
    return this.http.post<any>(this.createEmployeeUrl, createManagerRequest, httpOptions)
      .subscribe(res => {
        this.router.navigateByUrl('/');
        this.notificationService.success('Account successfully created. Please log in.');
      }, error => {
        console.log(error);
        this.notificationService.error('An error occured while attempting to create account. Account already exists.');
      });
  }

  registerAdmin(user: UserRegister) {
    console.log('registerAdmin');
  }
}
