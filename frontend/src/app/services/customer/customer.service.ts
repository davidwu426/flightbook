import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Constants } from '../../constants';
import { Customer } from '../../models/customer';
import { Flight } from '../../models/flight';
import { CreateCustomerRequest } from '../../models/create-customer-request';

@Injectable()
export class CustomerService {
  constructor(private http: HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(Constants.API_CUSTOMERS_URL);
  }

  addCustomer(createCustomerRequest: CreateCustomerRequest): Observable<Customer> {
    return this.http.post<Customer>(Constants.API_CUSTOMERS_URL, createCustomerRequest, Constants.HTTP_OPTIONS);
  }

  updateCustomer(customer: Customer): Observable<any> {
    const url = `${Constants.API_CUSTOMERS_URL}/${customer.accountNo}`;

    return this.http.put(url, customer, Constants.HTTP_OPTIONS);
  }

  deleteCustomer(accountNo: number): Observable<Customer> {
    const url = `${Constants.API_CUSTOMERS_URL}/${accountNo}`;

    return this.http.delete<Customer>(url, Constants.HTTP_OPTIONS);
  }

  getSuggestions(accountNo: number): Observable<Flight[]> {
    const url = `${Constants.API_SUGGESTIONS_URL}/${accountNo}`;

    return this.http.get<Flight[]>(url, Constants.HTTP_OPTIONS);
  }
}
