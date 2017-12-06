import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Flight } from '../../models/flight';
import { Constants } from '../../constants';

@Injectable()
export class FlightService {
  constructor(private http: HttpClient) { }

  getFlights(): Observable<Flight[]> {
    return this.http.get<Flight[]>(Constants.API_FLIGHTS_URL);
  }

  getDelayedFights(): Observable<Flight[]>
  {
    return this.http.get<Flight[]>(Constants.API_DELAYED_FLIGHTS_URL);
  }

  addFlight(flight: Flight): Observable<Flight> {
    return this.http.post<Flight>(Constants.API_FLIGHTS_URL, flight, Constants.HTTP_OPTIONS);
  }

  updateFlight(flight: Flight): Observable<any> {
    const url = `${Constants.API_FLIGHTS_URL}/${flight.airlineId}/${flight.flightNo}`;

    return this.http.put(url, flight, Constants.HTTP_OPTIONS);
  }

  deleteFlight(airlineId: string, flightNo: number): Observable<Flight> {
    const url = `${Constants.API_FLIGHTS_URL}/${airlineId}/${flightNo}`;

    return this.http.delete<Flight>(url, Constants.HTTP_OPTIONS);
  }

  getFlightsByAirport(airportId: string): Observable<Flight[]> {
    const url = `${Constants.API_FLIGHTS_BY_AIRPORT_URL}/${airportId}`;
    return this.http.get<Flight[]>(url, Constants.HTTP_OPTIONS);
  }
}
