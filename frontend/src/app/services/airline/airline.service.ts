import { Injectable } from '@angular/core';
import { Airline } from '../../models/airline';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from '../message/message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, tap } from 'rxjs/operators';
import { UserCredentials } from '../../models/user-credentials';
import { Constants } from '../../constants';

@Injectable()
export class AirlineService {
  constructor(private http: HttpClient) { }

  getAirlines(): Observable<Airline[]> {
    return this.http.get<Airline[]>(Constants.API_AIRLINES_URL);
  }

  getAirline(id: string): Observable<Airline> {
    const url = `${Constants.API_AIRLINES_URL}/${id}`;

    return this.http.get<Airline>(url);
  }

  addAirline(airline: Airline): Observable<Airline> {
    return this.http.post<Airline>(Constants.API_AIRLINES_URL, airline, Constants.HTTP_OPTIONS);
  }

  updateAirline(airline: Airline): Observable<any> {
    const url = `${Constants.API_AIRLINES_URL}/${airline.id}`;

    return this.http.put(url, airline, Constants.HTTP_OPTIONS);
  }

  deleteAirline(id: string): Observable<Airline> {
    const url = `${Constants.API_AIRLINES_URL}/${id}`;

    return this.http.delete<Airline>(url, Constants.HTTP_OPTIONS);
  }
}
