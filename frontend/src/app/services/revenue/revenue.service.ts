import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TotalBookingFee } from '../../models/total-booking-fee';
import { Constants } from '../../constants';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class RevenueService {

  constructor(private http: HttpClient) { }
  
    getRevenueByMonth(year: number, month: number): Observable<TotalBookingFee> {
      return this.http.get<TotalBookingFee>(`${Constants.API_REVENUE_URL}/${year}/${month}`);
    }
}
