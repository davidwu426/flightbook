import { Injectable } from '@angular/core';
import { Constants } from '../../constants';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Airport } from '../../models/airport';

@Injectable()
export class AirportService {
  private airportUrl = Constants.API_URL + '/airports';

  constructor(private http: HttpClient) { }

  getAirports(): Observable<Airport[]> {
    return this.http.get<Airport[]>(this.airportUrl);
  }
}
