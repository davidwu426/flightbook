import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TotalBookingFee } from '../../models/total-booking-fee';
import { Constants } from '../../constants';
import { Observable } from 'rxjs/Observable';
import { Employee } from '../../models/employee';
import { CustomerPerson } from '../../models/customer-person';

@Injectable()
export class RevenueService {

  constructor(private http: HttpClient) { }
  
    getRevenueByMonth(year: number, month: number): Observable<TotalBookingFee> {
      return this.http.get<TotalBookingFee>(`${Constants.API_REVENUE_URL}/${year}/${month}`);
    }

    getRevenueOfBestCustomerRep() : Observable<number>{
      return this.http.get<number>(`${Constants.API_REVENUE_BEST_REP_URL}`);
    }

    getRevenueOfBestCustomer() : Observable<CustomerPerson>{
      return this.http.get<CustomerPerson>(`${Constants.API_REVENUE_BEST_CUST_URL}`);
    }
}
