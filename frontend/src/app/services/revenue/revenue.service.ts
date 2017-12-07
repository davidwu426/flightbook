import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../../constants';
import { Observable } from 'rxjs/Observable';
import { Employee } from '../../models/employee';
import { CustomerPerson } from '../../models/customer-person';

@Injectable()
export class RevenueService {

  constructor(private http: HttpClient) { }
  
    getRevenueByMonth(year: number, month: number): Observable<number> {
      return this.http.get<number>(`${Constants.API_REVENUE_URL}/${year}/${month}`);
    }

    getRevenueByFlight(airlineId: string, flightNo: number): Observable<number> {
      return this.http.get<number>(`${Constants.API_REVENUE_BY_FLIGHT}/${airlineId}/${flightNo}`);
    }

    getRevenueByCity(city: string): Observable<number> {
      return this.http.get<number>(`${Constants.API_REVENUE_BY_CITY}/${city}`); 
    }

    getRevenueByAccountNo(accountNo: number): Observable<number> {
      return this.http.get<number>(`${Constants.API_REVENUE_BY_ACCOUNTNO}/${accountNo}`);
    }

    getRevenueOfBestCustomerRep() : Observable<number>{
      return this.http.get<number>(`${Constants.API_REVENUE_BEST_REP_URL}`);
    }

    getRevenueOfBestCustomer() : Observable<CustomerPerson>{
      return this.http.get<CustomerPerson>(`${Constants.API_REVENUE_BEST_CUST_URL}`);
    }
}
