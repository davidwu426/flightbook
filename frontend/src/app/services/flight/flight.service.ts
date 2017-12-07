import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient } from '@angular/common/http';
import { Flight } from '../../models/flight';
import { Constants } from '../../constants';
import { CustomerOnFlight } from '../../models/customer-on-flight';
import { FrequentFlight } from '../../models/frequent-flight';


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

  getOnTimeFlights() : Observable<Flight[]>
  {
    return this.http.get<Flight[]>(Constants.API_ON_TIME_FLIGHTS_URL);
  }

  getCustomerOnFlight(airlineId : string , flightNo : number) : Observable<CustomerOnFlight[]>
  {
    const url = `${Constants.API_CUSTOMER_ON_FLIGHT_URL}/${airlineId}/${flightNo}`;
    return this.http.get<CustomerOnFlight[]>(url, Constants.HTTP_OPTIONS);
  }

  getMostFrequentFlight(): Observable<FrequentFlight[]>
  {
    return this.http.get<FrequentFlight[]>(Constants.API_FREQUENT_FLIGHT_URL);
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
