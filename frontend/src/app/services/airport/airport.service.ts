import { Injectable } from '@angular/core';
import { Constants } from '../../constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Airport } from '../../models/airport';

@Injectable()
export class AirportService {
  constructor(private http: HttpClient) { }

  getAirports(): Observable<Airport[]> {
    return this.http.get<Airport[]>(Constants.API_AIRPORTS_URL);
  }

  addAirport(airport: Airport): Observable<Airport> {
    return this.http.post<Airport>(Constants.API_AIRPORTS_URL, airport, Constants.HTTP_OPTIONS);
  }

  updateAirport(airport: Airport): Observable<any> {
    const url = `${Constants.API_AIRPORTS_URL}/${airport.id}`;

    return this.http.put(url, airport, Constants.HTTP_OPTIONS);
  }

  deleteAirport(id: string): Observable<Airport> {
    const url = `${Constants.API_AIRPORTS_URL}/${id}`;

    return this.http.delete<Airport>(url, Constants.HTTP_OPTIONS);
  }
}
