import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../../constants';
import { Observable } from 'rxjs/Observable';
import { Leg } from '../../models/leg';

@Injectable()
export class LegService {
  constructor(private http: HttpClient) { }

  getLegsByFlightNo(airlineId: string, flightNo: number): Observable<Leg[]> {
    const url = `${Constants.API_FLIGHTS_URL}/${airlineId}/${flightNo}${Constants.API_LEGS}`;

    return this.http.get<Leg[]>(url);
  }

  addLeg(leg: Leg): Observable<Leg> {
    const url = `${Constants.API_FLIGHTS_URL}${Constants.API_LEGS}`;

    return this.http.post<Leg>(url, leg, Constants.HTTP_OPTIONS);
  }

  updateLeg(leg: Leg): Observable<any> {
    const url = `${Constants.API_FLIGHTS_URL}/${leg.airlineId}/${leg.flightNo}${Constants.API_LEGS}/${leg.legNo}`;

    return this.http.put(url, leg, Constants.HTTP_OPTIONS);
  }

  deleteLeg(airlineId: string, flightNo: number, legNo: number): Observable<Leg> {
    const url = `${Constants.API_FLIGHTS_URL}/${airlineId}/${flightNo}${Constants.API_LEGS}/${legNo}`;

    return this.http.delete<Leg>(url, Constants.HTTP_OPTIONS);
  }
}
