import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { SearchCriteria } from '../../models/search-criteria';
import { SearchEntry } from '../../models/search-entry';
import { Constants } from '../../constants';
import { FlightClass } from '../../models/flight-class';

type SearchType = 'oneway' | 'roundtrip' | 'multicity';

@Injectable()
export class SearchService {
  searchCriteria: SearchCriteria[] = [new SearchCriteria(), new SearchCriteria()];
  type: SearchType = 'oneway';
  flightClass: FlightClass = FlightClass.ECONOMY;

  constructor(private http: HttpClient) { }

  addCriteria() {
    if (this.searchCriteria.length < 5) {
      this.searchCriteria.push(new SearchCriteria());
    }
  }

  removeCriteria() {
    if (this.searchCriteria.length > 2) {
      this.searchCriteria.pop();
    }
  }

  searchOneWay(depAirport: string, arrAirport: string, depDate: Date, flightClass: string): Observable<SearchEntry[]> {
    let params = new HttpParams();
    params = params.append('depAirport', depAirport);
    params = params.append('arrAirport', arrAirport);
    params = params.append('depDate', `${new Date(depDate).getTime()}`);
    params = params.append('flightClass', flightClass);

    return this.http.get<SearchEntry[]>(Constants.API_SEARCH_ONEWAY, { params: params });
  }

  searchRoundTrip(depAirport: string, arrAirport: string, depDate: Date, retDate: Date, flightClass: string): Observable<SearchEntry[][]> {
    let params = new HttpParams();
    params = params.append('depAirport', depAirport);
    params = params.append('arrAirport', arrAirport);
    params = params.append('depDate', `${new Date(depDate).getTime()}`);
    params = params.append('retDate', `${new Date(retDate).getTime()}`);
    params = params.append('flightClass', flightClass);

    return this.http.get<SearchEntry[][]>(Constants.API_SEARCH_ROUNDTRIP, { params: params });
  }

  searchMultiCity(searchCriteria: SearchCriteria[], flightClass: string): Observable<SearchEntry[][]> {
    let params = new HttpParams();
    params = params.append('searchCriteria', JSON.stringify(searchCriteria));
    params = params.append('flightClass', flightClass);

    return this.http.get<SearchEntry[][]>(Constants.API_SEARCH_MULTICITY, { params: params });
  }
}
