import { Injectable } from '@angular/core';
import { UserRegister } from '../../models/user-register';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CreateCustomerRequest } from '../../models/create-customer-request';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {
  createCustomerUrl = 'http://localhost:8080/api/customers';
  createEmployeeUrl = 'http://localhost:8080/api/employees';
  createManagerUrl = 'http://localhost:8080/api/managers';

  constructor(private http: HttpClient) { }

  registerCustomer(createCustomerRequest: CreateCustomerRequest) {
    return this.http.post<any>(this.createCustomerUrl, createCustomerRequest, httpOptions)
      .subscribe(res => {
        console.log('successfully created user');
      }, error => {
        console.log(error);
      });
  }

  registerEmployee(user: UserRegister) {
    console.log('registerEmployee');
  }

  registerManager(user: UserRegister) {
    console.log('registerManager');
  }

  registerAdmin(user: UserRegister) {
    console.log('registerAdmin');
  }
}
